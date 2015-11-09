package org.agilej.sparkle.demo.module;

import org.agilej.sparkle.route.AbstractRouteModule;

public class DemoRouteModuleTwo extends  AbstractRouteModule {

    @Override
    public void configure() {
        get("/user/index").to("user#index");
        post("/users").to("user#save");
    }

}
