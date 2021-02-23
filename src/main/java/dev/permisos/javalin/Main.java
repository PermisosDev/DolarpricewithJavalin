package dev.permisos.javalin;

import dev.permisos.javalin.providers.WebsiteProvider;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WebsiteProvider provider = new WebsiteProvider();
        provider.start();
    }
}
