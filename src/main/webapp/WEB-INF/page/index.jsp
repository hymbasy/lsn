<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
    <meta name="author" content="Vincent Garreau"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" media="screen" href="<%=basePath%>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css"/>
    <script src="<%=basePath%>/js/jquery-3.0.0.min.js"></script>
    <script src="<%=basePath%>/js/md5.js"></script>
</head>
<body>

<div id="particles-js">
    <div class="login">
        <div class="login-top">
            登录
        </div>
        <form id="form" method="post" action="login" onsubmit='return checkForm()'>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="img/name.png"/></div>
                <div class="login-center-input">
                    <input type="text" id="username" name="userName" value="" placeholder="请输入您的用户名"
                           onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的用户名'"/>
                    <div class="login-center-input-text">用户名</div>
                </div>
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="img/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" id="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的密码'"/>
                    <div class="login-center-input-text">密码</div>
                    <input type='hidden' name='passWord' id='md5_pwd' value=""/>
                </div>
            </div>
            <div class="login-button">
                登录
            </div>
        </form>
    </div>
    <div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="<%=basePath%>/js/particles.min.js"></script>
<script src="<%=basePath%>/js/app.js"></script>
<script type="text/javascript">

    function checkForm() {
        var password_input = $("#password").val();
        var password_md5 = $("#md5_pwd").val();
        $("#md5_pwd").val($.md5(password_input))
        return true;
    }


    function hasClass(elem, cls) {
        cls = cls || '';
        if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
        return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
    }

    function addClass(ele, cls) {
        if (!hasClass(ele, cls)) {
            ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
        }
    }

    function removeClass(ele, cls) {
        if (hasClass(ele, cls)) {
            var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
            while (newClass.indexOf(' ' + cls + ' ') >= 0) {
                newClass = newClass.replace(' ' + cls + ' ', ' ');
            }
            ele.className = newClass.replace(/^\s+|\s+$/g, '');
        }
    }

    document.querySelector(".login-button").onclick = function () {
        $("#form").submit();
        /* addClass(document.querySelector(".login"), "active")
         setTimeout(function () {
             addClass(document.querySelector(".sk-rotating-plane"), "active")
             document.querySelector(".login").style.display = "none"
         }, 800)
         setTimeout(function () {
             removeClass(document.querySelector(".login"), "active")
             removeClass(document.querySelector(".sk-rotating-plane"), "active")
             document.querySelector(".login").style.display = "block"
             alert("登录成功")

         }, 5000)*/
    }
</script>
<div style="text-align:center;">
    <p>更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>