<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2017/1/10
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</nav>

<div class="container">
    <div class="row">

        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">
                <c:forEach var="orders" items="${ordersPageBean.list}">
                    <tbody>
                    <tr class="success">
                        <th colspan="5">订单编号:${orders.oid} </th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <c:forEach var="orderItem" items="${orders.orderitemList}">
                        <tr class="active">
                            <td width="60" width="40%">
                                <input type="hidden" name="id" value="22">
                                <img src="${pageContext.request.contextPath}/${orderItem.product.pimage}" width="70"
                                     height="60">
                            </td>
                            <td width="30%">
                                <a href="${pageContext.request.contextPath}/ProductServlet?method=findByPid&pid=${orderItem.product.pid}"
                                   target="_blank">${orderItem.product.pname}</a>
                            </td>
                            <td width="20%">
                                ￥${orderItem.product.shop_price}
                            </td>
                            <td width="10%">
                                    ${orderItem.count}
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${orderItem.subtotal}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:forEach>

            </table>
        </div>
    </div>
    <div style="text-align: center;">
        <ul class="pagination">
            <c:if test="${ordersPageBean.currPage==1}">
                <li class="disabled"><span aria-hidden="true">&laquo;</span></li>
            </c:if>

            <c:if test="${ordersPageBean.currPage!=1}">
                <li>
                    <a href="${pageContext.request.contextPath}/OrdersServlet?method=findAllByPage&currPage=${ordersPageBean.currPage-1}"
                       aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
            </c:if>

            <c:forEach var="i" begin="1" end="${odersPageBean.totalPage}">
                <c:if test="${odersPageBean.currPage!=i}">
                    <li>
                        <a href="${pageContext.request.contextPath}/OrdersServlet?method=findAllByPage&currPage=${i}">${i}</a>
                    </li>
                </c:if>

                <c:if test="${odersPageBean.currPage==i}">
                    <li><a href="#">${i}</a></li>
                </c:if>

            </c:forEach>
            <c:if test="${ordersPageBean.currPage==ordersPageBean.totalPage}">
                <li class="disabled">
                    <span aria-hidden="true">&raquo;</span>
                </li>
            </c:if>
            <c:if test="${ordersPageBean.currPage!=ordersPageBean.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/OrdersServlet?method=findAllByPage&currPage=${ordersPageBean.currPage+1}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

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

</html>