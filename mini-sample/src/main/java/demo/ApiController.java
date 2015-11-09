package demo;

import org.agilej.sparkle.*;
import org.agilej.sparkle.annotation.*;

@Controller("api")
public class ApiController{
    

    @Text
    public String get(WebRequest request) {
        
        return "{\"a\":1}";
    
    }

}
