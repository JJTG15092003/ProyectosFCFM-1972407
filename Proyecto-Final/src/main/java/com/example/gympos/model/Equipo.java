package com.example.gympos.model;

import java.io.Serializable;
import java.time.LocalDate;

//Inventario del gimnasio
public class Equipo implements Serializable
{

    private static final long serialVersionUID = 1L;

    public enum EstadoEquipo
    {DISPONIBLE, EN_USO, EN_MANTENIMIENTO, FUERA_DE_SERVICIO}

    private int id;
    private String nombre;
    private String descripcion;
    private EstadoEquipo estado;
    private LocalDate fechaAdquisicion;
    private LocalDate ultimoMantenimiento;
    private double valorAdquisicion;

    public Equipo()
    {
    }

    public Equipo(int id, String nombre, String descripcion, double valorAdquisicion)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorAdquisicion = valorAdquisicion;
        this.estado = EstadoEquipo.DISPONIBLE;
        this.fechaAdquisicion = LocalDate.now();
    }

    //Mantenimiento del equipo
    public void programarMantenimiento()
    {
        this.estado = EstadoEquipo.EN_MANTENIMIENTO;
    }

    //Registro de mantenimiento completado
    public void completarMantenimiento()
    {
        this.ultimoMantenimiento = LocalDate.now();
        this.estado = EstadoEquipo.DISPONIBLE;
    }

    //Mis getters y setters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public EstadoEquipo getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoEquipo estado)
    {
        this.estado = estado;
    }

    public LocalDate getFechaAdquisicion()
    {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fecha)
    {
        this.fechaAdquisicion = fecha;
    }

    public LocalDate getUltimoMantenimiento()
    {
        return ultimoMantenimiento;
    }

    public void setUltimoMantenimiento(LocalDate fecha)
    {
        this.ultimoMantenimiento = fecha;
    }

    public double getValorAdquisicion()
    {
        return valorAdquisicion;
    }

    public void setValorAdquisicion(double valor)
    {
        this.valorAdquisicion = valor;
    }
}
