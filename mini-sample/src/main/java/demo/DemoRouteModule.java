package demo;

import me.donnior.sparkle.route.RouteModule;
import me.donnior.sparkle.route.Router;

public class DemoRouteModule implements RouteModule {
    

    @Override
    public void config(Router router) {
        
        router.match("/test").to(request -> {
            return e -> {
                e.expose(200).withName("status");
                e.expose("OK").withName("msg");
            };
        });
    
    }

}
