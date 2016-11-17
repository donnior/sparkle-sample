package org.agilej.sparkle.demo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agilej.sparkle.Params;
import org.agilej.sparkle.WebRequest;
import org.agilej.sparkle.annotation.Async;
import org.agilej.sparkle.annotation.Controller;
import org.agilej.sparkle.annotation.Json;
import org.agilej.sparkle.annotation.Out;
import org.agilej.sparkle.annotation.Param;
import org.agilej.sparkle.annotation.ResponseBody;
import org.agilej.sparkle.http.HTTPStatusCode;
import org.agilej.sparkle.view.result.HttpStatus;

import org.agilej.fava.util.FLists;
import org.agilej.jsonty.JSONBuilder;
import org.agilej.jsonty.JSONModel;
import org.agilej.jsonty.support.AbstractJSONMoel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

@Controller("projects")
public class ProjectController {
    
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
    
    @Inject private Service service;
    
    @Out private String a;
    @Out private Service account;
    
    public String index(@Param("a") String a, @Param("b") Integer b, @Param("c") String[] c){
        System.out.println("a from param is " + a);
        this.a = a;
        return "projects/index";
    }
    
    public String show(WebRequest request){
        System.out.println(request.getSession("uid").toString());
        return "projects/show";
    }
    
    public String index2(Params params){
        System.out.println("param account : " + params.get("account"));
        return "projects/index2";
    }
    
    public String normalView(){
        return "";
    }
    
    public String redirectView(){
        return "redirect:users";
    }
    
    @Json
    public List<Object> jsonView(){
        
        return null;
    }
    
//    @Json
//    public Map<String, String> jsons(){
//        Map<String, String> maps = new HashMap<String, String>();
//        maps.put("name", "donny");
//        maps.put("age", "10");
//        return maps;
//    }
//  
    
    public JSONModel jsons(){
        this.service.hello();
        return new AbstractJSONMoel() {
            public void config() {
                expose(new int[]{1,2,3}).withName("ints");        //ints
                expose(new String[]{"one","two","three2"}).withName("strings");        //strings
            }
        };
    }
    
    @Json
    public List<String> json(HttpServletRequest request){
        return FLists.create("one", "two", "three", "four");
    }
    
    @ResponseBody
    public String responseBody(){
        return "";
    }
    
    public HttpStatus httpStatus(){
        return new HttpStatus(HTTPStatusCode.CREATED, "Post created");
    }
    
    public String save(){
        return "redirect: projects";
    }
    
    @Async
    public Callable<String> async0(){
        return new Callable<String>() {
            
            @Override
            public String call() throws Exception {
                System.out.println("execute callable code");
                throw new RuntimeException("test async exception");
                // return "callable";
            }
        };
    }
    
    @Async
    public String async1(){
        return "async";
    }
    
    public Callable<String> async2(){
        return new Callable<String>() {
            
            @Override
            public String call() throws Exception {
                return "callable";
            }
        };
    }
    
    public Object async3(){
        return new Callable<String>() {
            
            @Override
            public String call() throws Exception {
                return "callable";
            }
        }; 
    }
    
    public Object async4(){
        return "normal";
    }
    
    public void text(HttpServletResponse response){
        try {
//            logger.info("get text");
            response.getWriter().write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void streamJson(HttpServletResponse response){
        JSONModel model =  new AbstractJSONMoel() {
            public void config() {
                expose(new int[]{1,2,3}).withName("ints");        //ints
                expose(new String[]{"one","two","three2"}).withName("strings");        //strings
            }
        };
        try {
            new JSONBuilder(model).build(response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
