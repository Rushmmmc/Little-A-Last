package com.zhangmengcong.www.controller.usercontroller.changemessage;

import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zhangmengcong.www.constant.Constant.MANAGE_MEMBER;
import static com.zhangmengcong.www.constant.RequestConstant.MESSAGE_HAVE_BEEN_OCCUPIED;
import static com.zhangmengcong.www.constant.RequestConstant.MESSAGE_WRONG;


/**
 * @author:zmc function:
 * date:2020/4/27 15:28
 */
@WebServlet("/ChangeMemberMessage")
public class ChangeMemberMessage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newpassword");
        //从前端接收用户的新信息
        String newUsername = request.getParameter("newusername");
        String newaddress = request.getParameter("newmailaddress");
        String which = request.getParameter("which");
        int level = Integer.parseInt(request.getParameter("level"));
        if ("add".equals(which)) {
            if (!Factory.getAddMember().addMember(level, Factory.getEncode().shaEncode(newPassword), newaddress, newUsername)) {
                request.setAttribute("message", MESSAGE_HAVE_BEEN_OCCUPIED);
            }
        }else {
            if(!Factory.getServiceChangeMessage().changePersonalMessage(newUsername,Factory.getEncode().shaEncode(newPassword),newaddress,username,level)){
                request.setAttribute("message", MESSAGE_HAVE_BEEN_OCCUPIED);
            }
        }
        request.getRequestDispatcher("/ChangePage?method="+MANAGE_MEMBER).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
