package com.tutorialesvip.tutorialunittest.models;

import javax.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Long empleadoId;
    @Column(name = "numero_empleado")
    private String numeroEmpleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_ingreso")
    private String fechaIngreso;

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
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
}
