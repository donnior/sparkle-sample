package org.agilej.sparkle.demo;

import com.google.inject.Inject;
import org.agilej.sparkle.WebRequest;
import org.agilej.sparkle.Cookie;
import org.agilej.sparkle.Cookies;
import org.agilej.sparkle.Params;
import org.agilej.sparkle.annotation.*;
import org.agilej.sparkle.http.HTTPStatusCode;
import org.agilej.sparkle.view.result.HttpStatus;
import org.agilej.fava.util.FLists;
import org.agilej.jsonty.JSONBuilder;
import org.agilej.jsonty.JSONModel;
import org.agilej.jsonty.support.AbstractJSONMoel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@Controller("cookies")
public class CookiesController {
    
    private final static Logger logger = LoggerFactory.getLogger(CookiesController.class);
    
    @Inject private Service service;
    
    @Out private String a;
    @Out private Service account;
    
    public String remove(Cookies cookies){
        cookies.deleteCookie("sample_cookie");
        return "projects/index";
    }
    
    public String add(Cookies cookies){
        cookies.addCookie(new Cookie("sample_cookie").value(String.valueOf(System.currentTimeMillis())).maxAge(300000));
        return "projects/show";
    }

    public String addSession(WebRequest request){
        request.setSession("uid", "donny.xie");
        return "projects/show";
    }

}
