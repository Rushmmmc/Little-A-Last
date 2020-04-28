<%@ page import="com.zhangmengcong.www.po.Pdf" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/27
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传入口</title>
</head>
<body>
<a href="/login.jsp">返回登录页面</a>
<a href="/ChangePage?method=back">返回主页面</a>
<h1 align="center">欢迎 <font color="#8a2be2" >   ${sessionScope.username}</font> </h1>




<table border="1px" width="70%" align="center" cellspacing="0px">
    <tr>
        <th>Id</th>
        <th>Pdf文件名</th>
        <th>用户名</th>
        <th>存放时间</th>
        <th>在线观看</th>
        <th>想白嫖?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</th>
    </tr>


    <%
        List<Pdf> list = (List<Pdf>) request.getAttribute("pdfList");
        int i =1;
        for(Pdf pdf : list){
    %>
    <tr>
        <td><%=i++%></td>
        <td><%=pdf.getPdfName()%></td>
        <td><%=pdf.getUsername()%></td>
        <td><%=pdf.getDate()%></td>
        <td><a href="/<%=pdf.getUsername()%>/<%=pdf.getPdfName()%>">看他!</a></td>
        <td><a href="/<%=pdf.getUsername()%>/<%=pdf.getPdfName()%>"  download="<%=pdf.getPdfName()%>">马上白嫖！</a></td>
    <tr>
            <%
        }
    %>



</table>



</body>
</html>