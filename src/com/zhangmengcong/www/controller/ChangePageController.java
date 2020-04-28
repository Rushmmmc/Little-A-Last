package com.zhangmengcong.www.controller;

import com.zhangmengcong.www.po.Note;
import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.zhangmengcong.www.constant.Constant.*;
import static com.zhangmengcong.www.constant.MethodConstant.*;
import static com.zhangmengcong.www.constant.PageConstant.GO_LOGIN;


/**
 * @author:zmc function:
 * date:2020/4/21 20:16
 */
@WebServlet("/ChangePage")
public class ChangePageController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        String username = (String) session.getAttribute("username");
        int level = (int)session.getAttribute("level");
        //去往change页面 并在request中存储emps集合 不用放在session 这样用完即删
        if(CHANGE_PERSONOAL_MESSAGE.equals(method)){
            try {
                request.setAttribute("emps", Factory.getPrintTable().printPersonalMessage(username,false));
                request.getRequestDispatcher("/change.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        //去往change页面

        //去往管理员管理成员页面
        if(MANAGE_MEMBER.equals(method)){
            request.setAttribute("emps", Factory.getPrintTable().printPersonalMessage(null,true));
           try {
               request.getRequestDispatcher("/manageuser.jsp").forward(request,response);
           }
        catch (ServletException e) {
            e.printStackTrace();
        }
        }

        //返回主页面
        if(BACK.equals(method)){
            try {
                request.getRequestDispatcher(Factory.getWhereToGo().where(username)).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }


        //去往登录页面
        if(BACK_LOGIN.equals(method)){
            try {
                request.getRequestDispatcher(GO_LOGIN).forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        //去往游客页面
        if(VISITOR.equals(method)){
            try {
                request.getRequestDispatcher("/login?method=login&way=normal&username=visitor&password=visitor&captcha=qqqq").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        if(CHECK_NOTE.equals(method)){
            try {
                Note note = new Note();
                note.setHeader(request.getParameter("header"));
                note.setWriter(request.getParameter("writer"));
                note.setType(request.getParameter("type"));
                //当前页码
                String currentPage = request.getParameter("currentPage");
                //每页显示的条数
                String rows = request.getParameter("rows");
                request.setAttribute("textMessage",note);
                request.setAttribute("pb",Factory.getPageService().byPage(currentPage,rows,note));
                request.getRequestDispatcher("/Notes.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        if(READ_NOTE.equals(method)){
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("header",Factory.getTextImpl().getHeaderService(id));
                request.setAttribute("note",Factory.getTextImpl().getTextService(id));
                request.getRequestDispatcher("/ReadNote.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }


        if(GO_PDF.equals(method)){
            request.setAttribute("pdfList",Factory.getLoadService().getAllPdf());
            try {if(level == 2){
                request.getRequestDispatcher("/normalpdf.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/pdf.jsp").forward(request, response);
            }
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        if("mission".equals(method)){
            request.setAttribute("missionList",Factory.getMissionService().selectAllMission());
            try {
                request.setAttribute("zipList",Factory.getZipService().selectAllZip());
                request.getRequestDispatcher("/mission.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        if("checkMission".equals(method)){
            request.setAttribute("missionList",Factory.getMissionService().selectSomeOneMission(username));
            try {
                request.getRequestDispatcher("/checkMission.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        if("advice".equals(method)){
            String advice = request.getParameter("advice");
            int id = Integer.parseInt(request.getParameter("id"));
            Factory.getMissionService().giveAdivce(id,advice);
            try {
                request.getRequestDispatcher("/adminpage.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    this.doPost(request,response);
    }
}
