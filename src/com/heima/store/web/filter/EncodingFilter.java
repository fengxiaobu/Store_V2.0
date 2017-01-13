package com.heima.store.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by Feng on 2017/1/11.
 * 解决字符集乱码
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletRequest httpServletRequest = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();

                String requestMethod = request.getMethod();
                /**
                 * getParameterMap方法
                 */
                if (methodName.equals("getParameterMap")) {
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    if (parameterMap != null) {
                        if (requestMethod.equalsIgnoreCase("get")) {
                            for (String map : parameterMap.keySet()) {
                                String[] values = parameterMap.get(map);
                                for (int i = 0; i < map.length(); i++) {
                                    values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
                                }
                                return values;
                            }
                        } else if (requestMethod.equalsIgnoreCase("post")) {
                            request.setCharacterEncoding("UTF-8");
                        }
                    }
                }
                /**
                 * getParameter方法
                 */
                if (methodName.equals("getParameter")) {
                    if (requestMethod.equalsIgnoreCase("get")) {
                        String value = (String) method.invoke(request, args);
                        value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        return value;
                    } else if (requestMethod.equalsIgnoreCase("post")) {
                        request.setCharacterEncoding("UTF-8");
                    }
                }
                return method.invoke(request, args);
            }
        });
        chain.doFilter(httpServletRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
