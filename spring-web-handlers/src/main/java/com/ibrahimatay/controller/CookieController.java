package com.ibrahimatay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class CookieController {
    // http://localhost:8080/set-cookie
    // Cookie set successfully
    @GetMapping("/set-cookie")
    @ResponseBody
    public String setCookie(HttpServletResponse servletResponse) {
        servletResponse.addCookie(new Cookie("user-id", "ibrahimatay"));
        return "Cookie set successfully";
    }

    // http://localhost:8080/read-cookie1
    // user-id from cookie = [ibrahimatay]
    @GetMapping("/read-cookie1")
    @ResponseBody
    public String readCookie1(@CookieValue("user-id") String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    // http://localhost:8080/read-cookie2
    // user-id from cookie = [ibrahimatay]
    @GetMapping("/read-cookie2")
    @ResponseBody
    public String readCookie2(@CookieValue(name = "user-id", required = false, defaultValue = "N/A")String userId) {
        return String.format("user-id from cookie = [%s]\n", userId);
    }

    // http://localhost:8080/read-cookie3
    // user-id from cookie = [ibrahimatay]
    @GetMapping("/read-cookie3")
    @ResponseBody
    public String readCookie3(@CookieValue("user-id")Optional<String> userId) {
        return String.format("user-id from cookie = [%s]\n", userId.orElse("N/A"));
    }

    // http://localhost:8080/read-cookie4
    // Received cookie name = [user-id], value = [ibrahimatay]
    @GetMapping("/read-cookie4")
    @ResponseBody
    public String readCookie4(@CookieValue("user-id") Cookie cookie) {
        return String.format(
                "Received cookie name = [%s], value = [%s]\n",
                cookie.getName(), cookie.getValue()
        );
    }
}
