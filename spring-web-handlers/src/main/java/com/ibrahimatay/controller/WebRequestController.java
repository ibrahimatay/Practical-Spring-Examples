package com.ibrahimatay.controller;

import com.ibrahimatay.utils.StringJoinUtil;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

import static java.lang.String.format;

@Controller
public class WebRequestController {
    // http://localhost:8080/webRequestAction?name=ibrahim&city=istanbul
    // Retrieved request with headers = [host, connection, sec-ch-ua, sec-ch-ua-mobile, sec-ch-ua-platform, upgrade-insecure-requests, user-agent, accept, sec-fetch-site, sec-fetch-mode, sec-fetch-user, sec-fetch-dest, accept-encoding, accept-language], parameters = [name, city]
    @GetMapping("/webRequestAction")
    @ResponseBody
    public String webRequestAction(WebRequest webRequest) {
        return String.format(
                "Retrieved request with headers = [%s], parameters = [%s]\n",
                StringJoinUtil.join(webRequest.getHeaderNames()),
                StringJoinUtil.join(webRequest.getParameterNames())
        );
    }

    // http://localhost:8080/webNativeRequestAction?name=ibrahim&city=istanbul
    // Retrieved request with headers = [host, connection, sec-ch-ua, sec-ch-ua-mobile, sec-ch-ua-platform, upgrade-insecure-requests, user-agent, accept, sec-fetch-site, sec-fetch-mode, sec-fetch-user, sec-fetch-dest, accept-encoding, accept-language], parameters = [name, city]
    @GetMapping("/webNativeRequestAction")
    @ResponseBody
    public void webNativeRequestAction(NativeWebRequest nativeWebRequest) throws IOException {
        RequestFacade requestFacade = nativeWebRequest.getNativeRequest(RequestFacade.class);
        ResponseFacade responseFacade = nativeWebRequest.getNativeResponse(ResponseFacade.class);

        responseFacade.getOutputStream().println(
                format(
                        "Retrieved request with headers = [%s], parameters = [%s]",
                        StringJoinUtil.join(requestFacade.getHeaderNames()),
                        StringJoinUtil.join(requestFacade.getParameterNames())
                )
        );
    }
}
