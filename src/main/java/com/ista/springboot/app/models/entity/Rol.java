package com.ista.springboot.app.models.entity;

public class Rol {


    private String nombre;
    private int hora;

    public Rol(String nombre, int hora) {

        this.nombre = nombre;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}