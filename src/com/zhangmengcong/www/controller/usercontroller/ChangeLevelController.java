package com.zhangmengcong.www.controller.usercontroller;

import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:zmc function:
 * date:2020/4/27 12:09
 */
@WebServlet("/ChangeLevelController")
public class ChangeLevelController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int level = Integer.parseInt(request.getParameter("level"));
        String username = (String)session.getAttribute("username");
        Factory.getChangeLevelService().changeLevelService(username,level);
        session.setAttribute("level", level);
        session.setAttribute("sendLevel", Factory.getEstimateStatus().estimateStatus(level));
        request.getRequestDispatcher(Factory.getWhereToGo().where(username)).forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
