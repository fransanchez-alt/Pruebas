package com.fran.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController() {
        this.jugadorService = new JugadorService();
        // Inicializar datos al crear el controlador
        //this.jugadorService.inicializarDatos();
        /*  Comentado para evitar reinicialización 
        en cada instancia del controlador, ya que la base de datos se inicializa 
        *una sola vez al inicio de la aplicación y ya contiene los datos necesarios.*/
    }

    @GetMapping("/jugadores")
    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorService.obtenerTodosLosJugadores();
    }

    @GetMapping("/jugadores/{id}")
    public Jugador obtenerJugadorPorId(@PathVariable Long id) {
        return jugadorService.obtenerJugadorPorId(id);
    }
}