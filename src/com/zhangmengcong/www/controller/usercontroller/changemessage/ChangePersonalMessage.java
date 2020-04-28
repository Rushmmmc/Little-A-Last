package com.zhangmengcong.www.controller.usercontroller.changemessage;


import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


import static com.zhangmengcong.www.constant.MethodConstant.CHANGE_USER_PASS;
import static com.zhangmengcong.www.constant.RequestConstant.MESSAGE_HAVE_BEEN_OCCUPIED;


/**
 * @author:zmc function:
 * date:2020/4/25 0:04
 */
@WebServlet("/ChangePersonalMessage")
public class ChangePersonalMessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        String username = (String)session.getAttribute("username");

        //实现修改个人信息功能
        if (CHANGE_USER_PASS.equals(method)) {
            String newPassword = request.getParameter("newpassword");
            //从前端接收用户的新信息
            String newUsername = request.getParameter("newusername");
            String newaddress = request.getParameter("newaddress");
            if(Factory.getServiceChangeMessage().changePersonalMessage(newUsername,Factory.getEncode().shaEncode(newPassword),newaddress,username,0)){
                //修改cookie和session否则会出错
                session.setAttribute("username",newUsername);
                Cookie cookie = new Cookie("username", newUsername);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
            }else {
                request.setAttribute("message",MESSAGE_HAVE_BEEN_OCCUPIED);
            }
            request.getRequestDispatcher(Factory.getWhereToGo().where(username)).forward(request,response);
        }
        //实现修改个人信息功能

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
