package dev.permisos.javalin.providers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class CotizacionProvider {
    public String getValores() throws IOException {
        OkHttpClient client = new OkHttpClient();
        JsonParser parser = new JsonParser();

        Request request = new Request.Builder().url("https://www.dolarsi.com/api/api.php?type=valoresprincipales").build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JsonArray cotizaciones = parser.parse(body).getAsJsonArray();
        StringBuilder resultado = new StringBuilder();
        for (JsonElement cotizacion : cotizaciones) {
            JsonObject temp = cotizacion.getAsJsonObject();
            JsonObject casa = temp.getAsJsonObject("casa");
            String nombre = casa.get("nombre").getAsString();
            String compra = casa.get("compra").getAsString();
            String venta = casa.get("venta").getAsString();
            resultado.append(nombre).append("\nCompra: ").append(compra).append("\nVenta: ").append(venta).append("\n--------------------\n");
        }
        return String.valueOf(resultado);
    }

}
