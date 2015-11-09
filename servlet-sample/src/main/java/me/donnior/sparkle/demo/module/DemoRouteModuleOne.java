package org.agilej.sparkle.demo.module;

import org.agilej.sparkle.route.RouteModule;
import org.agilej.sparkle.route.Router;

public class DemoRouteModuleOne implements RouteModule {
    

    @Override
    public void config(Router router) {
        
        router.match("/").to("home#index");
        
        router.match("/projects").to("projects#index2");
        
        router.match("/projects").matchParams("a=1","b!=2", "c").to("projects#index");
        
        router.match("/projects/{name}").withPost().to("projects#save");
        
        router.match("/projects/{name}").to("projects#show");
        
        router.match("/users/{name}/projects/{id}").to("projects#show");
        
        router.match("/project/jsons").to("projects#jsons");
        
        router.match("/project/json").to("projects#json");
        
        router.match("/project/async0").to("projects#async0");
        router.match("/project/async1").to("projects#async1");
        router.match("/project/async2").to("projects#async2");
        router.match("/project/async3").to("projects#async3");
        router.match("/project/async4").to("projects#async4");
        
        router.match("/project/text").to("projects#text");
        router.match("/project/streamJson").to("projects#streamJson");

        router.match("/cookies/add").to("cookies#add");
        router.match("/cookies/remove").to("cookies#remove");

        router.match("/session/add").to("cookies#addSession");

    }

}
