<%@ page import="com.zhangmengcong.www.po.Mission" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zhangmengcong.www.po.Zip" %><%--
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
<form align="center">
<a href="/EditMission.jsp"><font  color="#00ffff">发布任务</font></a>
</form>


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
            <tr>
            <%
    }
%>
</table>
                <table border="1px" width="70%" align="center" cellspacing="0px">
                    <tr>
                        <th>Id</th>
                        <th>文件名</th>
                        <th>提交人</th>
                        <th>提交时间</th>
                        <th>下载</th>
                    </tr>
                    <!--通过循环 显示信息-->



                        <%
         List<Zip> zipList = (List<Zip>)request.getAttribute("zipList");;
        for(Zip zip :zipList){
    %>
                    <tr>
                        <td><%=zip.getId()%></td>
                        <td><%=zip.getZipName()%></td>
                        <td><%=zip.getUsername()%></td>
                        <td><%=zip.getDate()%></td>
                        <td><a href="/<%=zip.getUsername()%>/<%=zip.getZipName()%>"  download="<%=zip.getZipName()%>">下载</a></td>
                    <tr>
                            <%
    }
%>
                    </table>


                                <form   action="/ChangePage?method=advice"  method="post" align="center">
                                    <h1 >发布通知</h1>
                                    要发布通知的任务ID<br>
                                    ID:<input type="text"  name="id" pattern="[\w]{1,100}" required/>
                                    <br>
                                    通知:<input type="text"  name="advice"  required/>
                                    <br>
                                    <input type="submit"  value="提交通知" style="width:140px; height:30px;"/>
                                </form>



</body>
</html>
