package com.fran.apidemo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KKClienteJugadores {

    // Método simple para hacer GET, similar a GestorPeticionesHTTP pero adaptado
    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception {
        StringBuilder respuesta = new StringBuilder();
        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/json");
        int estado = conexion.getResponseCode();

        Reader streamReader = null;
        if (estado == HttpURLConnection.HTTP_OK) {
            streamReader = new InputStreamReader(conexion.getInputStream());
            int caracter;
            while ((caracter = streamReader.read()) != -1) {
                respuesta.append((char) caracter);
            }
        } else {
            throw new Exception("Error HTTP " + estado);
        }

        if (streamReader != null) {
            streamReader.close();
        }
        conexion.disconnect();
        return respuesta;
    }

    public static void main(String[] args) {
        KKClienteJugadores cliente = new KKClienteJugadores();
        try {
            // Petición a localhost:8080/jugadores
            String direccion = "http://localhost:8080/jugadores";
            StringBuilder resultado = cliente.getContenidoMetodoGet(direccion);
            System.out.println("Respuesta del servidor:");
            System.out.println(resultado.toString());

            // Petición a un jugador específico
            direccion = "http://localhost:8080/jugadores/1";
            resultado = cliente.getContenidoMetodoGet(direccion);
            System.out.println("Jugador con ID 1:");
            System.out.println(resultado.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}