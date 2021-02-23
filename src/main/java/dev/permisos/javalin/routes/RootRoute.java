package dev.permisos.javalin.routes;

import dev.permisos.javalin.providers.CotizacionProvider;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class RootRoute implements Handler {
    CotizacionProvider cotiprov = new CotizacionProvider();

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        ctx.result(cotiprov.getValores()); System.out.println(ctx.ip());}
    }
