package com.example.gympos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Pagos del cliente
public class Pago implements Serializable
{

    private static final long serialVersionUID = 1L;

    public enum MetodoPago
    {EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA}

    public enum EstadoPago
    {PENDIENTE, COMPLETADO, RECHAZADO, REEMBOLSADO}

    private int id;
    private Cliente cliente;
    private Membresia membresia;
    private double monto;
    private MetodoPago metodoPago;
    private EstadoPago estado;
    private LocalDateTime fechaHora;
    private String referencia;

    public Pago()
    {
    }

    public Pago(int id, Cliente cliente, Membresia membresia, double monto, MetodoPago metodoPago)
    {
        this.id = id;
        this.cliente = cliente;
        this.membresia = membresia;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = EstadoPago.PENDIENTE;
        this.fechaHora = LocalDateTime.now();
        this.referencia = generarReferencia();
    }

    //Cambiar estado a completado si es exitoso
    public boolean procesar()
    {
        if (this.estado == EstadoPago.PENDIENTE)
        {
            this.estado = EstadoPago.COMPLETADO;
            return true;
        }
        return false;
    }

    //Generar el folio
    public String generarReferencia()
    {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "REF-" + fecha + "-" + id;
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

    public Membresia getMembresia()
    {
        return membresia;
    }

    public void setMembresia(Membresia membresia)
    {
        this.membresia = membresia;
    }

    public double getMonto()
    {
        return monto;
    }

    public void setMonto(double monto)
    {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago()
    {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago)
    {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoPago estado)
    {
        this.estado = estado;
    }

    public LocalDateTime getFechaHora()
    {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora)
    {
        this.fechaHora = fechaHora;
    }

    public String getReferencia()
    {
        return referencia;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }
}
