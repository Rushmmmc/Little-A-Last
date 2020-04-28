package com.zhangmengcong.www.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.zhangmengcong.www.constant.PageConstant.CAPTCHA;
import static com.zhangmengcong.www.constant.PageConstant.LOGIN_SERVLET;

/**
 * @author zmc
 * @version 1.0
 * @date 2020/4/15 11:52
 */
@WebFilter("/*")
public class FilterController implements javax.servlet.Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if ( uri.contains(LOGIN_SERVLET) || uri.contains(CAPTCHA)
    || uri.contains("/style.css") || uri.contains("/3.jpg") || uri.contains("/Register.jsp")
        || uri.contains("/page") || uri.contains("/login.jsp") || uri.contains("/Register") ||uri.contains("/forget.jsp") ||
        uri.contains("/SendMailController")){
            chain.doFilter(req, resp);
        }else {
            Object userName = request.getSession().getAttribute("username");
            if(userName != null){
                chain.doFilter(req, resp);
            }else{
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }



    }

    @Override
    public void init(FilterConfig config) {

    }

}
