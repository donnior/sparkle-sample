package demo;

import org.agilej.sparkle.route.RouteModule;
import org.agilej.sparkle.route.Router;

public class DemoRouteModule implements RouteModule {
    

    @Override
    public void config(Router router) {
        
        router.match("/test/{id}").to(request -> {
            return e -> {
                e.expose(200).withName("status");
                e.expose("OK").withName("msg");
                e.expose(request.pathVariable("id")).withName("id");
            };
        });

        router.match("/api/{path}").to("api#get");
    
    }

}
