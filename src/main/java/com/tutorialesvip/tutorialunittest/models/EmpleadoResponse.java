package com.tutorialesvip.tutorialunittest.models;

public class EmpleadoResponse {
    private String numeroEmpleado;
    private String nombre;
    private String fechaIngreso;
    private int añosCumplidos;
    private int mesesCumplidos;
    private int diasCumplidos;

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getAñosCumplidos() {
        return añosCumplidos;
    }

    public void setAñosCumplidos(int añosCumplidos) {
        this.añosCumplidos = añosCumplidos;
    }

    public int getMesesCumplidos() {
        return mesesCumplidos;
    }

    public void setMesesCumplidos(int mesesCumplidos) {
        this.mesesCumplidos = mesesCumplidos;
    }

    public int getDiasCumplidos() {
        return diasCumplidos;
    }

    public void setDiasCumplidos(int diasCumplidos) {
        this.diasCumplidos = diasCumplidos;
    }
}
