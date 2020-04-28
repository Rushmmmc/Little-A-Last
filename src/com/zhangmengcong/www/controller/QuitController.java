package com.zhangmengcong.www.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import static com.zhangmengcong.www.constant.LoginRegisterConstant.USER_NAME;
import static com.zhangmengcong.www.constant.MethodConstant.QUIT;

/**
 * @author:zmc function:
 * date:2020/4/21 20:57
 */
@WebServlet("/Quit")
public class QuitController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        //实现注销功能
        if (QUIT.equals(method)) {
            if (session.getAttribute(USER_NAME) != null) {
                //session中name不存在,即session已经被销毁
                Cookie cookie = new Cookie("username","destroy");
                cookie.setMaxAge(60);
                response.addCookie(cookie);
                session.invalidate();
                //删除session即可
                request.setAttribute("message","false");
                response.setHeader("refresh", "0;url=/login.jsp");
            }
        }
        //实现注销功能
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    this.doPost(request,response);
    }
}
