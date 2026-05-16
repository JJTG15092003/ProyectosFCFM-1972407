package com.example.gympos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Clase grupal
public class ClaseGrupal implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String instructor;
    private LocalDateTime fechaHora;
    private int capacidadMaxima;
    private List<Cliente> inscritos;
    private int duracionMinutos;
    private String salon;

    public ClaseGrupal()
    {
        this.inscritos = new ArrayList<>();
    }

    public ClaseGrupal(int id, String nombre, String instructor, LocalDateTime fechaHora,
                       int capacidadMaxima, int duracionMinutos, String salon)
    {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.fechaHora = fechaHora;
        this.capacidadMaxima = capacidadMaxima;
        this.duracionMinutos = duracionMinutos;
        this.salon = salon;
        this.inscritos = new ArrayList<>();
    }

    //Inscribir al cliente si hay espacios
    public boolean inscribirCliente(Cliente cliente)
    {
        if (lugaresDisponibles() > 0 && !inscritos.contains(cliente))
        {
            inscritos.add(cliente);
            return true;
        }
        return false;
    }

    //Cancelar la inscripcion del cliente
    public boolean cancelarInscripcion(Cliente cliente)
    {
        return inscritos.remove(cliente);
    }

    //Lugares disponibles
    public int lugaresDisponibles()
    {
        return capacidadMaxima - inscritos.size();
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

    public String getInstructor()
    {
        return instructor;
    }

    public void setInstructor(String instructor)
    {
        this.instructor = instructor;
    }

    public LocalDateTime getFechaHora()
    {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora)
    {
        this.fechaHora = fechaHora;
    }

    public int getCapacidadMaxima()
    {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidad)
    {
        this.capacidadMaxima = capacidad;
    }

    public List<Cliente> getInscritos()
    {
        return inscritos;
    }

    public void setInscritos(List<Cliente> inscritos)
    {
        this.inscritos = inscritos;
    }

    public int getDuracionMinutos()
    {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracion)
    {
        this.duracionMinutos = duracion;
    }

    public String getSalon()
    {
        return salon;
    }

    public void setSalon(String salon)
    {
        this.salon = salon;
    }
}
