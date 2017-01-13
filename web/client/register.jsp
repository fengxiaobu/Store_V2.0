<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2017/1/10
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head></head>
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
        color: #3164af;
        font-size: 18px;
        font-weight: normal;
        padding: 0 10px;
    }
</style>
<script>


</script>
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
     style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
    <div class="row">

        <div class="col-md-2"></div>
        <div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <form class="form-horizontal" style="margin-top:5px;" method="post" action="/UserServlet">
                <input type="hidden" name="method" value="register">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control required" name="username" id="username" placeholder="请输入用户名" required>
                    </div>
                    <span id="chacknuserame"></span>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" name="password" class="form-control required" id="password"
                               placeholder="请输入密码" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" name="repassword" class="form-control required" id="repassword"
                               placeholder="请输入确认密码" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-6">
                        <input type="email" name="email" class="form-control required" id="email" placeholder="Email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" name="name" class="form-control required" id="name" placeholder="请输入姓名" required>
                    </div>
                </div>
                <div class="form-group opt">
                    <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio1" value="男" checked="checked"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input type="date" name="birthday" id="birthday" class="form-control required" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control required" id="telephone" name="telephone" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control required" id="code_text" name="code_img" required>
                    </div>
                    <div class="col-sm-2">
                        <img src="${pageContext.request.contextPath}/CheckImgServlet" id="code_img"/>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" id="sub_mit" value="注册" name="submit" border="0"
                               style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
                                       height:35px;width:100px;color:white;">
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>

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
    <!--验证用户名是否存在-->
    function chick_username() {
        var $value = $(this).val();
        if ($value != "") {
            $.post("${pageContext.request.contextPath}/UserServlet", {
                "method": "chackUsername",
                "username": $value
            }, function (data) {
                if (data == 0) {
                    $("#chacknuserame").html("<font  class='form_tips'  style='font-size: 10px;color: green'>用户名可以使用!</font>");
                    $("#sub_mit").prop("disabled", false)
                } else if (data == 1) {
                    $("#chacknuserame").html("<font  class='form_tips' style='font-size: 10px;color: red'>用户名已被占用!</font>");
                    $("#sub_mit").prop("disabled", true);
                }
            });
        }
    }
    <!--必填项标记*-->
    $(function () {
        $("form input.required").each(function() {
            $(this).parent().parent().append("<b style='color: red'>*</b>");
        });

        //文本校验
        $("form input").blur(function () {
            var $parent = $(this).parent();
            $parent.find(".form_tips").remove();
            <!--验证用户名-->
            if ($(this).is("#username")) {
                var reg = /^[a-z0-9_-]{3,16}$/;
                var val = $(this).val();
                //alert($(this).val());
                if (val == "") {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>用户名不能为空!</span>");
                } else if (!reg.test(val)) {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>用户输入错误!</span>");
                }else{
                    chick_username();
                }
            }
            <!--验证密码-->
            if ($(this).is("#password")) {
                var reg = /^[a-z0-9_-]{3,18}$/;
                var pwd = $(this).val();
                if (pwd == "") {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>密码不能为空!</span>");
                } else if (!reg.test(pwd)) {
                    $parent.append("<span class='form_tips' style='font-size: 11px;color: red;'>密码长度为3-18位!</span>");
                }
            }
            if ($(this).is("#repassword")) {
                var $repwd = $("this").val();
                if ($repwd == "") {
                    //$("sub_mit").prop("disabled", true);
                    $(this).parent().append("<span class='form_tips' style='font-size: 11px;color: red;'>请输入密码</span>");
                } else if($repwd==$("#password").val()){
                    $(this).parent().append("<span class='form_tips' style='font-size: 11px;color: red;'>请输入密码</span>");
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


        }).keyup(function () {
            $(this).triggerHandler("blur");
        }).focus(function () {
            $(this).triggerHandler("blur");
        });
        $("form").submit(function () {
            $("form input").trigger("blur");
            var len = $(".form_tips").length;
            if (len > 0) {
                return false;
            }
        });

    });
</script>
</html>




