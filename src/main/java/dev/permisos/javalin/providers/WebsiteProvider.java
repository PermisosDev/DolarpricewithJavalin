package dev.permisos.javalin.providers;

import io.javalin.Javalin;
import dev.permisos.javalin.routes.RootRoute;


import java.io.IOException;

public class WebsiteProvider  {
    public void start() throws IOException {
        new Thread(() -> {
            Javalin app = Javalin.create().start(7000);
            app.get("/", new RootRoute());
        }, "WebProvider-Thread").start();
    }

}
