<%@ page import="com.zhangmengcong.www.po.Note" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zhangmengcong.www.po.PageBean" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/26
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">

<a href="/login.jsp">返回登录页面</a>
<a href="/ChangePage?method=back">返回主页面</a>
<html>
<head>
    <title>笔记列表</title>
</head>
<body>

<h1 align="center"><font color="aqua">小A的小伙伴可随时沉浸在知识的海洋哦</font></h1>
<form class="form-inline" align="center" action="/ChangePage?method=CheckNote" method="post">
    <div class="form-group">
        <label>笔记类型</label>
        <input type="text" value="${requestScope.textMessage.type}" class="form-control" name="type">
    </div>
    <div class="form-group">
        <label>作者名称</label>
        <input type="text" value="${requestScope.textMessage.writer}" class="form-control" name="writer">
    </div>
    <div class="form-group">
        <label>笔记标题</label>
        <input type="text" value="${requestScope.textMessage.header}" class="form-control" name="header">
    </div>

    <input type="submit" value="模糊查询">

</form>




<table border="1px" width="70%" align="center" cellspacing="0px">
    <tr>
        <th>Id</th>
        <th>Type</th>
        <th>Header</th>
        <th>Writer</th>
        <th>Date</th>
        <th>偷看笔记</th>
    </tr>
    <!--通过循环 显示信息-->



     <%
         PageBean<Note> pb = (PageBean<Note>) request.getAttribute("pb");
        for(Note note :pb.getList()){
    %>
    <tr>
        <td><%=note.getId()%></td>
        <td><%=note.getType()%></td>
        <td><%=note.getHeader()%></td>
        <td><%=note.getWriter()%></td>
        <td><%=note.getDate()%></td>
        <td><a href="/ChangePage?method=ReadNote&id=<%=note.getId()%>">偷偷观看</a></td>
    <tr>
<%
    }
%>



</table>
<% int i = 1;%>
<form align="center">
    <nav  aria-label="Page navigation" >
        <ul class="pagination">
            <li>
                <a href="/ChangePage?method=CheckNote&currentPage=<%if(i!=1) --i;%><%=i%>
&rows=3" aria-label="Next">        <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="/ChangePage?method=CheckNote&currentPage=1&rows=3&header=${requestScope.textMessage.header}
&writer=${requestScope.textMessage.writer}&type=${requestScope.textMessage.type}">1</a></li>
            <li><a href="/ChangePage?method=CheckNote&currentPage=2&rows=3&clanname=${requestScope.textMessage.header}
&writer=${requestScope.textMessage.writer}&type=${requestScope.textMessage.type}">2</a></li>
            <li><a href="/ChangePage?method=CheckNote&currentPage=3&rows=3&clanname=${requestScope.textMessage.header}
&writer=${requestScope.textMessage.writer}&type=${requestScope.textMessage.type}">3</a></li>
            <li><a href="/ChangePage?method=CheckNote&currentPage=4&rows=3&clanname=${requestScope.textMessage.header}
&writer=${requestScope.textMessage.writer}&type=${requestScope.textMessage.type}">4</a></li>
            <li><a href="/ChangePage?method=CheckNote&currentPage=5&rows=3&clanname=${requestScope.textMessage.header}
&writer=${requestScope.textMessage.writer}&type=${requestScope.textMessage.type}">5</a></li>
            <li>
                <a href="/ChangePage?method=CheckNote&currentPage=<%if(i!=pb.getTotalPage()) ++i;%><%=i%>
&rows=3" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <h2><font color="aqua">共<%=pb.getTotalCount()%>条信息,共<%=pb.getTotalPage()%>页</font></h2>

        </ul>
    </nav>

</form>





</table>


<c:if test="${not empty requestScope.message}">
    <Script Language="JavaScript">
        alert("${requestScope.message}");
    </Script>

</c:if>

</body>
</html>
