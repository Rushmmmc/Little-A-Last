package com.zhangmengcong.www.controller;

import com.zhangmengcong.www.util.Factory;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.zhangmengcong.www.constant.Constant.MESSAGE_WRONG;

/**
 * @author:zmc function:
 * date:2020/4/26 16:30
 */
@WebServlet("/GetNoteOrGetMission")
public class GetNoteOrGetMission extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String header = request.getParameter("title");
        String text = request.getParameter("md");
        String group = Factory.getGroupService().getGroupServiceImpl(username);
        int level = (int) session.getAttribute("level");
        String method = request.getParameter("method");

        if (username == null || header == null || text == null || level == 1) {
            request.setAttribute("message", MESSAGE_WRONG);
        }
        if ("note".equals(method)) {
            Factory.getAddOrEditService().addOrEditServiceImpl(header, text, username, group);
            request.getRequestDispatcher("/ChangePage?method=CheckNote").forward(request, response);
        }
        if ("mission".equals(method)){
            String finisher = request.getParameter("finisher");
            String deadline = request.getParameter("deadline");
            Factory.getMissionService().addMission(username,header,text,finisher,deadline);
            request.getRequestDispatcher("/adminpage.jsp").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
