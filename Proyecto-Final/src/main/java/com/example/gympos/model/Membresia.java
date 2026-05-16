package com.example.gympos.model;

import java.io.Serializable;
import java.time.LocalDate;

//Membresia del gimnasio
public class Membresia implements Serializable
{

    private static final long serialVersionUID = 1L;

    public enum TipoPlan
    {MENSUAL_BASIC_PRO, ENCLENQUE_TRIMESTRAL, PLUS_ULTRA, ANUAL_PLATINO_PLUS_DORADA_ULTRA_MAX}

    private int id;
    private Cliente cliente;
    private TipoPlan tipoPlan;
    private double precio;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private boolean activa;
    private double descuentoAplicado;

    public Membresia()
    {
    }

    public Membresia(int id, Cliente cliente, TipoPlan tipoPlan, double precio)
    {
        this.id = id;
        this.cliente = cliente;
        this.tipoPlan = tipoPlan;
        this.precio = precio;
        this.fechaInicio = LocalDate.now();
        this.activa = true;
        calcularFechaVencimiento();
    }

    //Calcular fecha de vencimiento segun el plan
    private void calcularFechaVencimiento()
    {
        switch (tipoPlan)
        {
            case MENSUAL_BASIC_PRO -> this.fechaVencimiento = fechaInicio.plusMonths(1);
            case ENCLENQUE_TRIMESTRAL -> this.fechaVencimiento = fechaInicio.plusMonths(3);
            case PLUS_ULTRA -> this.fechaVencimiento = fechaInicio.plusMonths(6);
            case ANUAL_PLATINO_PLUS_DORADA_ULTRA_MAX -> this.fechaVencimiento = fechaInicio.plusYears(1);
        }
    }

    //Renovacion de membresia
    public void renovar()
    {
        this.fechaInicio = LocalDate.now();
        this.activa = true;
        calcularFechaVencimiento();
    }

    //Verificar si la membresia ya vencio
    public boolean estaVencida()
    {
        return LocalDate.now().isAfter(fechaVencimiento);
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

    public TipoPlan getTipoPlan()
    {
        return tipoPlan;
    }

    public void setTipoPlan(TipoPlan tipoPlan)
    {
        this.tipoPlan = tipoPlan;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public LocalDate getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento()
    {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento)
    {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isActiva()
    {
        return activa;
    }

    public void setActiva(boolean activa)
    {
        this.activa = activa;
    }

    public double getDescuentoAplicado()
    {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuento)
    {
        this.descuentoAplicado = descuento;
    }
}
