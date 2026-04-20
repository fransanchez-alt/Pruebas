package com.fran.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String inicio() {
        return "Servidor funcionando";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola Fran";
    }

    @GetMapping("/usuario")
    public Usuario getUsuario() {
        return new Usuario(1L, "Fran", "fran@example.com");
    }
}


