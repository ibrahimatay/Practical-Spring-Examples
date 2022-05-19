package com.ibrahimatay.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/getcookie"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                System.out.println(String.format("Cookie Name:%s - Value:%s", cookie.getName(), cookie.getValue()));
            }
        } else {
            System.out.println("it doesn't exist");
        }
    }
}
