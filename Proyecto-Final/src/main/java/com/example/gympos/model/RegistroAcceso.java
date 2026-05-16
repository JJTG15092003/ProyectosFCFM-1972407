package com.example.gympos.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

//Registro de accesos y salidas del gym
public class RegistroAcceso implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;
    private Cliente cliente;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public RegistroAcceso()
    {
    }

    public RegistroAcceso(int id, Cliente cliente)
    {
        this.id = id;
        this.cliente = cliente;
        this.horaEntrada = LocalDateTime.now();
    }

    //Registrar la salida del cliente
    public void registrarSalida()
    {
        if (horaSalida == null)
        {
            this.horaSalida = LocalDateTime.now();
        }
    }

    //Tiempo que se estuvo en el gym en minutos
    public long calcularTiempoEstancia()
    {
        if (horaSalida == null)
        {
            return Duration.between(horaEntrada, LocalDateTime.now()).toMinutes();
        }
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    //El cliente aun esta adentro?
    public boolean estaActivo()
    {
        return horaSalida == null;
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

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public LocalDateTime getHoraEntrada()
    {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada)
    {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida()
    {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida)
    {
        this.horaSalida = horaSalida;
    }
}
