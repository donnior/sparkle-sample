package me.donnior.sparkle.demo;

import com.google.inject.Inject;
import me.donnior.sparkle.Cookie;
import me.donnior.sparkle.Cookies;
import me.donnior.sparkle.Params;
import me.donnior.sparkle.annotation.*;
import me.donnior.sparkle.http.HTTPStatusCode;
import me.donnior.sparkle.view.result.HttpStatus;
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

}
