package org.agilej.sparkle.demo;

import org.agilej.sparkle.annotation.Controller;

@Controller("home")
public class HomeController {
    
    public String index(){
        return "index";
    }

}
