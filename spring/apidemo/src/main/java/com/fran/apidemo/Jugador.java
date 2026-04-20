package com.fran.apidemo;

public class Jugador {

    private Long id;
    private String nombre;
    private String posicion;
    private int edad;

    public Jugador() {}

    public Jugador(Long id, String nombre, String posicion, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                '}';
    }
}