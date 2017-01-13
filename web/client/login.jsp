<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2017/1/10
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- 引入自定义css文件 style.css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
            float:left; */
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
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

<div class="container"
     style="width:100%;height:460px;background:#FF2C4C url('${pageContext.request.contextPath}/images/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
            <!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
        </div>

        <div class="col-md-5">
            <div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
                <font>会员登录</font>
                <font style="font-size: 12px;color: red">${msg}</font>
                <div>&nbsp;</div>
                <form class="form-horizontal" method="post"
                      action="${pageContext.request.contextPath}/UserServlet">
                    <input type="hidden" name="method" value="login">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="codeimg" name="code_img"
                                   placeholder="请输入验证码">
                        </div>
                        <div class="col-sm-3">
                            <img src="${pageContext.request.contextPath}/CheckImgServlet" id="code_img"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="auto_login" value="true"> 自动登录
                                </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>
                                    <input type="checkbox" name="save_username" value="true"> 记住用户名
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" id="sub_mit" value="登录" name="submit" border="0"
                                   style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                                           height:35px;width:100px;color:white;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div style="margin-top:50px;">
    <img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势"/>
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
    $(function () {
        // $("form input").parent().append("<b style='color: red'>*</b>");
        $("form input").blur(function () {
            var $parent = $(this).parent();
            $parent.find(".form_tips").remove();
            if ($(this).is("#username")) {
                var reg = /^[a-z0-9_-]{3,16}$/;
                var val = $(this).val();
                //alert($(this).val());
                if (val == "") {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>用户名不能为空!</span>");
                } else if (!reg.test(val)) {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>用户输入错误!</span>");
                }
            }

            if ($(this).is("#codeimg")) {
                var $codeimg_val = $("#codeimg").val();
                if ($codeimg_val == "") {
                    $("sub_mit").prop("disabled", true);
                    $(this).parent().append("<span class='form_tips' style='font-size: 11px;color: red;'>请输入验证码</span>");
                } else {
                    //alert($codeimg_val);
                    //$.post();
                }
            }

            if ($(this).is("#password")) {
                var reg = /^[a-z0-9_-]{3,18}$/;
                var pwd = $(this).val();
                if (pwd == "") {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>密码不能为空!</span>");
                } else if (!reg.test(pwd)) {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>密码长度为3-18位!</span>");
                }
            }
        }).keyup(function () {
            $(this).triggerHandler("blur");
        }).focus(function () {
            $(this).triggerHandler("blur");
        });
        $("form").submit(function () {
            $("form input").trigger("blur");
//            var $codeimg_val = $("#codeimg").val();
//            var $username = $("#username").val();
//            var $passsword = $("#passsword").val();
            var len = $(".form_tips").length;
            if (len > 0) {
                return false;
            }
            /*if ($codeimg_val == "" || $username == "" || $passsword == "") {
             //$(this).prop("disabled", true);
             // $(this).parent().append("<span style='font-size: 11px;color: red;'>请输入验证码</span>");
             return false;
             }*/
        });

    });
</script>
</html>

