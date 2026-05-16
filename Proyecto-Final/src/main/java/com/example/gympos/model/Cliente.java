package com.example.gympos.model;

import java.io.Serializable;
import java.time.LocalDate;

//Cliente registrado
public class Cliente implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;
    private int puntos;

    public Cliente()
    {
    }

    public Cliente(int id, String nombre, String apellido, String email, String telefono)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = LocalDate.now();
        this.puntos = 0;
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

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro()
    {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro)
    {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPuntos()
    {
        return puntos;
    }

    public void setPuntos(int puntos)
    {
        this.puntos = puntos;
    }

    //Agregar puntos al cliente
    public void agregarPuntos(int cantidad)
    {
        if (cantidad > 0)
        {
            this.puntos += cantidad;
        }
    }

    @Override
    public String toString()
    {
        return nombre + " " + apellido + " (ID: " + id + ")";
    }
}
