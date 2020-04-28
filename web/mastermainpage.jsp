<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/14
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">

    <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
    <script src="jquery-3.5.0.min.js"></script>
    <script src="./bootstrap/js/bootstrap.js"></script>
    <title>小A知识共享系统</title>
</head>
<body >
<a href="/login.jsp">返回登录页面</a>
<h1 align="center">欢迎 <font color="#8a2be2" >   ${sessionScope.username}</font> </h1>
<h1 align="center">你是 <font color="#1e90ff" >   ${sessionScope.sendLevel}</font> </h1>
<h3 align="center"><font color="#663399">超级管理员可以管理所有成员,普通成员可以查看大部分学习资料,游客仅可以查看笔记</font>  </h3 >

<form action="/Quit?method=quit" method="post" align="center"  >
    <a href="/ChangePage?method=checkMission"> <h1><font color="red">接受灭天榜的试炼</font></h1></a>
    <a href="/ChangePage?method=goPdf"> <h3><font color="red">查看pdf电子书库</font></h3></a>
    <a href="/ChangePage?method=gochange">查询及修改个人信息</a>
    <a href="/ChangeLevelController?level=3">一键成为超级管理员</a>
    <a href="/ChangeLevelController?level=2">一键成为普通成员</a>
    <a href="/ChangePage?method=CheckNote">查看笔记库</a>
    <br>
    <input type="submit" name="" value="Quit" >
</form>





<c:if test="${not empty requestScope.message}">
    <Script Language="JavaScript">
        alert("${requestScope.message}");
    </Script>

</c:if>




<c:if test="${not empty requestScope.zipFail}">
    <Script Language="JavaScript">
    alert("${requestScope.zipFail}");
    </Script>
</c:if>

</body>
</html>
