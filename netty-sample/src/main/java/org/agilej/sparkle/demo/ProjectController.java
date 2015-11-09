package org.agilej.sparkle.demo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import org.agilej.fava.util.FLists;
import org.agilej.sparkle.Params;
import org.agilej.sparkle.WebRequest;
import org.agilej.sparkle.WebResponse;
import org.agilej.sparkle.annotation.Async;
import org.agilej.sparkle.annotation.Controller;
import org.agilej.sparkle.annotation.Json;
import org.agilej.sparkle.annotation.Out;
import org.agilej.sparkle.annotation.Param;
import org.agilej.sparkle.annotation.ResponseBody;
import org.agilej.sparkle.http.HTTPStatusCode;
import org.agilej.sparkle.view.result.HttpStatus;

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
        return "projects/indexlaal";
    }
    
    public String show(){
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
    public List<String> json(){
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
                return "callable";
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

    public JSONModel streamJson(WebRequest request){
        JSONModel model =  new AbstractJSONMoel() {
            public void config() {
                expose(new int[]{1,2,3}).withName("ints");        //ints
                expose(new String[]{"one","two","three2"}).withName("strings");        //strings
            }
        };

        return model;
    }    

    public static void main(String[] args){
        logger.info("should be printed");
        System.out.println("ha");
    }
}
