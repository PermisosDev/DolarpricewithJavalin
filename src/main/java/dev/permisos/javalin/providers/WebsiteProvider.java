package dev.permisos.javalin.providers;

import dev.permisos.javalin.providers.CotizacionProvider;
import io.javalin.Javalin;
import routes.RootRoute;


import java.io.IOException;

public class WebsiteProvider  {
    public void start() throws IOException {
        new Thread(() -> {
            Javalin app = Javalin.create().start(7000);
            app.get("/", new RootRoute());
        }, "WebProvider-Thread").start();
    }

}
