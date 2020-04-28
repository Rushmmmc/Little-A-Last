<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.zhangmengcong.www.po.Mission" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/27
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>灭天榜</title>
</head>
<body>
<a href="/login.jsp">返回登录页面</a>
<a href="/ChangePage?method=back">返回主页面</a>

<h1 align="center"><font color="red">灭天榜 完成者生 失败者死！</font></h1>



<table border="1px" width="70%" align="center" cellspacing="0px">
    <tr>
        <th>Id</th>
        <th>Designer</th>
        <th>Header</th>
        <th>content</th>
        <th>Finisher</th>
        <th>DeadLine</th>
        <th>status</th>
        <th>通知</th>
        <th>提交</th>
    </tr>
    <!--通过循环 显示信息-->



        <%
         List<Mission> list =(List<Mission>)request.getAttribute("missionList");
        for(Mission mission :list){
    %>
    <tr>
        <td><%=mission.getId()%></td>
        <td><%=mission.getDesigner()%></td>
        <td><%=mission.getHeader()%></td>
        <td><%=mission.getContent()%></td>
        <td><%=mission.getFinisher()%></td>
        <td><%=mission.getDeadline()%></td>
        <td><%=mission.getStatus()%></td>
        <td><%=mission.getAdvice()%></td>
        <td><form action="/Load?method=zip&id=<%=mission.getId()%>" enctype="multipart/form-data" method="post">
            <input type="file" name="file" required >
            <input type="submit" value="提交">
        </form>
        </td>
    <tr>
            <%
    }
%>



</body>
</html>
