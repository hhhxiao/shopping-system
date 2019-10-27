package com.xhy.shoppingsystem.filter;

import com.xhy.shoppingsystem.pojo.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;

@Component
@WebFilter
public class UserFilter implements javax.servlet.Filter {

    private String[] filter_list = {"/buy","/id", "/item", "/index", "/manage", "/record", "/get-record"};

    private boolean needFilter(String url) {
        for (String uri : filter_list)
            if (url.startsWith(uri))
                return true;
        return false;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter is set!!!");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (needFilter(uri)) {
            System.out.println(uri + "  need filter");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
            } else {
                if (uri.startsWith("/manage") && user.getUserType() == 1) {
                    request.getRequestDispatcher("/index").forward(servletRequest, servletResponse);
                }
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
