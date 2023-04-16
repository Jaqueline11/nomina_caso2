package com.ista.springboot.app.models.entity;


public class ItemFactura {

    private Empleado empleado;

    private Rol rol;
    private  double costo;


    public ItemFactura(Empleado empleado, Rol rol, double costo) {
        this.empleado = empleado;
        this.rol = rol;
        this.costo = costo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
