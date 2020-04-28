package com.zhangmengcong.www.controller.usercontroller;

import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zhangmengcong.www.constant.Constant.MAIL_FAIL;
import static com.zhangmengcong.www.constant.Constant.MAIL_SUCCESS;

/**
 * @author:zmc function:
 * date:2020/4/25 16:04
 */
@WebServlet("/SendMailController")
public class SendMailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //设置编码防止乱码
        //获取区域 从前端获取各种信息 method的存在使得一个Servlet可以做很多事
        String address = request.getParameter("address");
        String username;
        if(Factory.getForgetPasswordImpl().checkMail(address)){
            username = Factory.getForgetPasswordImpl().getUsername(address);

        Factory.getSendMailService().sendMail(address);
            request.setAttribute("message",MAIL_SUCCESS);

    }else {
            request.setAttribute("message",MAIL_FAIL);
        }
        try {
            request.getRequestDispatcher("/forget.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    this.doPost(request,response);
    }
}
