<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.zhangmengcong.www.po.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/14
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理成员</title>



</head>
<body>
<a href="/ChangePage?method=backlogin">返回登录页面</a>
<a href="/ChangePage?method=back">返回主页面</a>







<table border="1px" width="70%" align="center" cellspacing="0px">
    <tr>
        <th>Id</th>
        <th>Gro&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</th>
        <th>Username</th>
        <th>Password</th>
        <th>MailAddress</th>
        <th>Level</th>
        <th>Register_date</th>
    </tr>
    <!--通过循环 显示信息-->


    <%
        List<User> emps = (List<User>)request.getAttribute("emps");
        for(User user :emps){
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getGro()%></td>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getMailAddress()%></td>
        <td><%=user.getLevel()%></td>
        <td><%=user.getRegisterDate()%></td>
    <tr>
            <%
        }
    %>




</table>



<form   action="/ChangeMemberMessage" method="post" align="center"  >

    要修改成员<br>
    的名称:<input type="text"  name="username" pattern="[\w]{4,10}" required/>
    <br>
    新名称:<input type="text"  name="newusername" pattern="[\w]{4,10}" required/>
    <br>
    新密码:<input type="password"  name="newpassword" pattern="[\w]{4,10}" required/>
    <br>
    新邮箱:<input type="text"  name="newmailaddress" pattern="^[0-9A-Za-z][\.-_0-9A-Za-z]*@[0-9A-Za-z]+(?:\.[0-9A-Za-z]+)+$" required/>
    </br>
    新等级:<input type="text"  name="level" pattern="[\w]{1,1}" required/>
    <br>
    <select name="which">
        <option value="change">修改成员</option>
        <option value="add">增加成员</option>
    </select>
    <br>
    注意:如部分信息不需要改,则输入原信息即可,用户名和电话不可与其他用户相同,用户名、密码为4-10 电话号码长度8-12 仅支持数字及字母
    <br>
    <input type="submit"  value="Change" style="width:70px; height:30px;"/>


</form>


</body>
</html>
