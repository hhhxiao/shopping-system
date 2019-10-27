package com.xhy.shoppingsystem.filter;

import com.xhy.shoppingsystem.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {
        "/item/*","/index","manage","/id/*"})
public class UserFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter is set!!!");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login").forward(request, servletResponse);
        } else {
            if (user.getUserType() == 1 && request.getRequestURI().contains("manage")) {
                request.getRequestDispatcher("/index").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
