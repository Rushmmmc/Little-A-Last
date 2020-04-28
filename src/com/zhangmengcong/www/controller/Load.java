package com.zhangmengcong.www.controller;

import com.zhangmengcong.www.po.Pdf;
import com.zhangmengcong.www.util.Factory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

import static com.zhangmengcong.www.constant.Constant.PDF_FAIL;
import static com.zhangmengcong.www.constant.Constant.UPLOAD;

/**
 * @author:zmc function:
 * date:2020/4/26 15:04
 */
@WebServlet("/Load")
public class Load extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //设置编码
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String method = request.getParameter("method");
        List<Pdf> list1;
        Pdf pdf = new Pdf();
        list1 = Factory.getLoadService().getAllPdf();
        session.setAttribute("list", list1);

            //获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //获取文件需要上传到的路径
            String path = request.getRealPath("./" + username);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs(); //创建目录
            }
            factory.setRepository(new File(path));
            //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024);
            //高水平的API文件上传处理

                ServletFileUpload upload = new ServletFileUpload(factory);
                //可以上传多个文件
            List<FileItem> list = null;
            try {
                list = (List<FileItem>) upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            for (FileItem item : list) {
                    //获取表单的属性名字
                    String name = item.getFieldName();
                    //如果获取的 表单信息是普通的 文本 信息
                    if (item.isFormField()) {
                        //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
                        String value = item.getString();
                        request.setAttribute(name, value);
                    } else {//对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
                        //获取路径名
                        String value = item.getName();
                        //索引到最后一个反斜杠
                        int start = value.lastIndexOf("\\");
                        //截取 上传文件的 字符串名字，加1是 去掉反斜杠，
                        String filename = value.substring(start + 1);
                        if("pdf".equals(method)){
                            if (!Factory.getLoadService().savePdf(username, path, filename)) {
                                request.setAttribute(PDF_FAIL,"该pdf文件已存在");
                                request.getRequestDispatcher("/pdf.jsp").forward(request, response);
                            }
                        }

                        if("zip".equals(method)){
                            if(!Factory.getZipService().saveZip(username,filename,path)){
                                request.setAttribute("zipFail","该zip已存在" );
                            }else {
                                int id = Integer.parseInt(request.getParameter("id"));
                                Factory.getMissionService().finishMission(id);
                            }
                        }
                            OutputStream out = new FileOutputStream(new File(path, filename));
                            InputStream in = item.getInputStream();
                            int length;
                            byte[] buf = new byte[1024];
                            // in.read(buf) 每次读到的数据存放在 buf 数组中
                            while ((length = in.read(buf)) != -1) {
                                //在 buf 数组中 取出数据 写到 （输出流）磁盘上
                                out.write(buf, 0, length);
                            }
                            in.close();
                            out.close();
                        if("pdf".equals(method)) {
                            request.setAttribute("pdfList", Factory.getLoadService().getAllPdf());
                            request.getRequestDispatcher("/pdf.jsp").forward(request, response);
                        }else {
                            request.getRequestDispatcher("/mastermainpage.jsp").forward(request,response);
                        }
                        }
                }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
