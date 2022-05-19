package com.ibrahimatay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(urlPatterns={"/methods"})
public class RequestMethodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale locale = req.getLocale();
        int localPort = req.getLocalPort();
        int serverPort = req.getServerPort();
        String remoteAddr = req.getRemoteAddr();
        String hostname = req.getHeader("host");

        System.out.println(String.format("locale:%s\nlocalPort:%s\nserverPort:%s\nremoteAddr:%s\nhostname:%s", locale, localPort, serverPort, remoteAddr, hostname));
    }
}
