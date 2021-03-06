<%@ page import="com.zhangmengcong.www.po.Note" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Rush
  Date: 2020/4/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./Editor/css/editormd.min.css" />
    <script src="./Editor/js/editormd.js" type="text/javascript" charset="utf-8"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sco.js/1.1.0/css/sco.message.min.css" rel="stylesheet">
    <!--    <link href="https://cdn.bootcss.com/jquery-confirm/3.3.2/jquery-confirm.min.css" rel="stylesheet">-->
    <link rel="stylesheet" href="./Editor/css/style.css" />
    <link rel="stylesheet" href="./Editor/css/editormd.css" />
    <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="./Editor/js/editormd.min.js"></script>


</head>
<body>
<a href="/login.jsp">返回登录页面</a>
<a href="/ChangePage?method=back">返回主页面</a>
<a href="/mission.jsp">返回灭天榜</a>
<!-- 构造form表单，以便提交数据-->
<form id="formBlog" action="/GetNoteOrGetMission?method=mission" method="post">
    需要完成任务的成员:<input name="finisher" required></input>
    死线:<input name="deadline" required></input>
    <input id="blog_title" name="title" value="" required style="display: none;"></input>
    <textarea id="blog_md" name="md" value=""required style="display: none;"></textarea>
    <textarea id="blog_html" name="html" value="" required style="display: none;"></textarea>
    <input type="submit" name="" value="上传" >
</form>
<div class="row">
    <div class="panel panel-primary">
        <div class="page-header">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 col-sm-3">
                        <input type="text" value="${requestScope.header}" class="form-control" id="art-head" name="art-head" placeholder="标题">
                    </div>
                    <div class="col-md-2 col-sm-1">
                        <button class="btn btn-success btn-blog-save">发布内容</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <div class="row">
                <!-- md文件编辑器编辑区域 后续js中会使用到 -->
                <div id="blog_mdedit">

                    <textarea style="display:none;" >${requestScope.note}</textarea>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        md_edit = editormd("blog_mdedit", { //注意1：这里的就是上面的DIV的id属性值
            placeholder : '  欢迎使用'+'${title}' +" 博客",
            width : "90%",
            height : 400,
            syncScrolling : "single",
            emoji : true,
            path : "./Editor/lib/", //注意2：你的路径
            saveHTMLToTextarea : true,
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            /* 上传图片配置 */
            imageUpload : true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "${proPath }/base/blog/upFile", //注意你后端的上传图片服务地址
        });
    });
</script>

<script type="text/javascript">
    $('.btn-blog-save').click(function() {
        $("#formBlog")[0].reset();//清空表单数据，避免上次数据干扰
        $("#blog_title").val($("#art-head").val());
        $("#blog_md").val(md_edit.getMarkdown());//md格式内容，使用md的js获取
        $("#blog_html").val(md_edit.getHTML());
        $("#formBlog").ajaxSubmit({
            success : function(da) {
                $.scojs_message('发布成功', $.scojs_message.TYPE_OK);
                var uname='${logUser.username}';
                if(uname||uname==''){
                    uname='zhuzi';
                }
                location="/blog/rush";
            }
        });
    });
</script>


<c:if test="${not empty requestScope.message}">
    <Script Language="JavaScript">
        alert("${requestScope.message}");
    </Script>

</c:if>



</body>
</html>