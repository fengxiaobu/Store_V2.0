<%@ page import="com.heima.store.utils.CookieUtils" %>
<%@ page import="com.heima.store.service.ProductService" %>
<%@ page import="com.heima.store.service.impl.ProductServiceImpl" %>
<%@ page import="com.heima.store.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2017/1/10
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String reqUrl = request.getRequestURL().toString();
    reqUrl = reqUrl.substring(0, 22);

    String queryString = request.getQueryString();
    if (queryString != null) {
        reqUrl += "ProductServlet?" + queryString;
    }
    request.getSession().setAttribute("url_list", reqUrl);
%>

<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/client/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/client/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
            width: 100%;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }
    </style>
</head>

<body>

<!--
    时间：2015-12-30
    描述：菜单栏
-->

<!--
    时间：2015-12-30
    描述：导航条
-->

<jsp:include page="/client/top.jsp"></jsp:include>

<div class="row" style="width:1210px;margin:0 auto;">
    <div class="col-md-12">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/client/index.jsp">首页</a></li>
        </ol>
    </div>
    <c:forEach var="p" items="${productList.list}">
        <div class="col-md-2">
            <a href="${pageContext.request.contextPath}/ProductServlet?method=findByPid&pid=${p.pid}">
                <img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170"
                     style="display: inline-block;">
            </a>
            <p><a href="${pageContext.request.contextPath}/ProductServlet?method=findByPid&pid=${p.pid}"
                  style='color:green'>${fn:substring(p.pname,0 ,7 )}</a></p>
            <p><font color="#FF0000">商城价：&yen;${p.shop_price}</font></p>
        </div>
    </c:forEach>

</div>

<!--分页 -->
<div style="width:380px;margin:0 auto;margin-top:50px;">
    <ul class="pagination" style="text-align:center; margin-top:10px;">
        <c:if test="${productList.currPage==1}">
            <li class="disabled">
                <a href="#"
                   aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
            </li>
        </c:if>
        <c:if test="${productList.currPage!=1}">
            <li>
                <a href="${pageContext.request.contextPath}/ProductServlet?method=findByCid&currPage=${productList.currPage-1}&cid=${pageCid}"
                   aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
            </li>
        </c:if>
        <c:forEach var="i" begin="1" end="${productList.totalPage}">
            <c:if test="${productList.currPage==i}">
                <li class="active"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${productList.currPage!=i}">
                <li>
                    <a href="${pageContext.request.contextPath}/ProductServlet?method=findByCid&currPage=${i}&cid=${pageCid}">${i}</a>
                </li>
            </c:if>
        </c:forEach>
        <c:if test="${productList.currPage==productList.totalPage}">
            <li class="disabled">
                <a href="#"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${productList.currPage!=productList.totalPage}">
            <li>
                <a href="${pageContext.request.contextPath}/ProductServlet?method=findByCid&currPage=${productList.currPage+1}&cid=${pageCid}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</div>
<!-- 分页结束=======================        -->

<!--
       商品浏览记录:
-->
<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

    <h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
    <h5><a href="${pageContext.request.contextPath}/ProductServlet?method=clearHistry"
           onclick="clear_history()">清空浏览记录</a></h5>
    <div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
    <div style="clear: both;"></div>

    <div style="overflow: hidden;">

        <ul style="list-style: none;">
            <%
                Cookie[] cookies = request.getCookies();
                Cookie historyValue = CookieUtils.getCookie(cookies, "history");
                if (historyValue != null) {
                    String value = historyValue.getValue();
                    String[] split = value.split("_");
                    ProductService productService = new ProductServiceImpl();
                    for (String pid : split) {
                        Product p = productService.findByPid(pid);
                        pageContext.setAttribute("p", p);
            %>
            <a href="${pageContext.request.contextPath}/ProductServlet?method=findByPid&pid=${p.pid}">
                <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
                    <img src="${pageContext.request.contextPath}/${p.pimage}" width="130px"
                         height="130px"/></li>
            </a>

            <%
                    }
                } else {
                    out.print("<h3>亲,你还没有浏览过商品呢!</h3>");
                }
            %>

        </ul>

    </div>
</div>
<div style="margin-top:50px;">
    <img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势"
         title="我们的优势"/>
</div>

<div style="text-align: center;margin-top: 5px;">
    <ul class="list-inline">
        <li><a>关于我们</a></li>
        <li><a>联系我们</a></li>
        <li><a>招贤纳士</a></li>
        <li><a>法律声明</a></li>
        <li><a>友情链接</a></li>
        <li><a target="_blank">支付方式</a></li>
        <li><a target="_blank">配送方式</a></li>
        <li><a>服务声明</a></li>
        <li><a>广告声明</a></li>
    </ul>
</div>
<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
    Copyright &copy; 2005-2016 传智商城 版权所有
</div>

</body>
<script>
    /*  $(function () {
     $.post("${pageContext.request.contextPath}/ProductServlet?method=loadCookie", {"dis": null}, function (date) {
     alert(date);
     }, "json");
     });
     function clear_history() {

     }*/

</script>
</html>