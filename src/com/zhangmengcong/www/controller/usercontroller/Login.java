package com.zhangmengcong.www.controller.usercontroller;



//import com.zhangmengcong.www.po.PageBean;
import com.zhangmengcong.www.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import static com.zhangmengcong.www.constant.Constant.BACK_LOGIN;
import static com.zhangmengcong.www.constant.LoginRegisterConstant.*;
import static com.zhangmengcong.www.constant.PageConstant.GO_LOGIN;
import static com.zhangmengcong.www.constant.RequestConstant.HAVENOT_COOKIE;
import static com.zhangmengcong.www.constant.RequestConstant.MESSAGE_WRONG;

/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/14 11:56
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //设置编码防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //设置编码防止乱码
        //获取区域 从前端获取各种信息 method的存在使得一个Servlet可以做很多事
        String method = request.getParameter("method");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String captcha = request.getParameter("captcha");
        if(password == null || username == null || captcha == null){
            password = username = captcha = "";
            //防止用户使用cookie登录时发生NPE
        }
        int level;
        //获取session
        HttpSession session = request.getSession();
        //从另一个Servlet中接受验证码图片中的字符
        String captchar = (String) session.getAttribute("captcha");
        //获取区域

        //获取cookie
        boolean ifCookieExist =false;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie :cookies){
                if(USER_NAME.equals(cookie.getName()) && !cookie.getValue().contains("destroy")){
                    ifCookieExist = true;
                    username = cookie.getValue();
                }
            }
        }
        //获取cookie

        //实现登录功能
        if (LOGIN.equals(method)) {
            String way = request.getParameter("way");
            if (COOKIE.equals(way)) {
                if (!ifCookieExist) {
                    request.setAttribute("cookiemessage", HAVENOT_COOKIE);
                }
            }
                if (Factory.getRegisterAndLogin().login(username, Factory.getEncode().shaEncode(password), captcha, captchar) || ifCookieExist) {
                    //用户信息正确并且验证码输入正确 或存在cookie 才能允许登陆
                    Cookie cookie = new Cookie("username", username);
                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);
                    level = Factory.getUserDao().getlevel(username);
                    //调用检索等级方法,获取用户的等级
                    session.setAttribute("username", username);
                    //登陆成功,在session储存用户名
                    session.setAttribute("level", level);
                    session.setAttribute("sendLevel", Factory.getEstimateStatus().estimateStatus(level));
                    try {
                        request.getRequestDispatcher(Factory.getWhereToGo().where(username)).forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    request.setAttribute("message", MESSAGE_WRONG);
                    try {
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                }
        }
            //实现登录功能
    }

        @Override
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
            this.doPost(request, response);
        }


}


