package com.example.gympos.controller;

import com.example.gympos.exception.MembresiaException;
import com.example.gympos.exception.PersistenciaException;
import com.example.gympos.model.Cliente;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.Membresia.TipoPlan;
import com.example.gympos.service.PersistenciaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador de membresias
public class controladorMembresia
{

    private List<Membresia> membresias;
    private PersistenciaService persistencia;
    private int nextId;

    public controladorMembresia()
    {
        this.persistencia = new PersistenciaService();
        this.membresias = new ArrayList<>();
        this.nextId = 1;
        cargarDatos();
    }

    //Crear membresia
    public Membresia crearMembresia(Cliente cliente, TipoPlan plan,
                                    double descuento) throws MembresiaException
    {
        Membresia activa = obtenerMembresiaActiva(cliente);
        if (activa != null)
        {
            throw new MembresiaException("El cliente ya tiene una membresia activa");
        }

        double precioBase = calcularPrecio(plan);
        double precioFinal = precioBase - (precioBase * (descuento / 100.0));

        Membresia membresia = new Membresia(nextId++, cliente, plan, precioFinal);
        membresia.setDescuentoAplicado(descuento);
        membresias.add(membresia);
        guardarDatos();
        return membresia;
    }

    //Renovacion de membresia
    public void renovarMembresia(int membresiaId) throws MembresiaException
    {
        Membresia membresia = membresias.stream()
                .filter(m -> m.getId() == membresiaId)
                .findFirst()
                .orElseThrow(() -> new MembresiaException("No se encontro la membresia con ID: " + membresiaId));

        membresia.renovar();
        guardarDatos();
    }

    //Mostrar membresias proximas a vencer
    public List<Membresia> obtenerProximasAVencer(int dias)
    {
        LocalDate limite = LocalDate.now().plusDays(dias);
        return membresias.stream()
                .filter(m -> m.isActiva()
                        && !m.getFechaVencimiento().isAfter(limite)
                        && !m.estaVencida())
                .collect(Collectors.toList());
    }

    //Mostrar membresia activa si ya existe
    public Membresia obtenerMembresiaActiva(Cliente cliente)
    {
        return membresias.stream()
                .filter(m -> m.getCliente().getId() == cliente.getId()
                        && m.isActiva()
                        && !m.estaVencida())
                .findFirst()
                .orElse(null);
    }

    //Mostrar todas las membresias
    public List<Membresia> obtenerTodas()
    {
        return new ArrayList<>(membresias);
    }

    //Mostrar precio sin descuento
    public double calcularPrecio(TipoPlan plan)
    {
        return switch (plan)
        {
            case MENSUAL_BASIC_PRO -> 299.0;
            case ENCLENQUE_TRIMESTRAL -> 799.0;
            case PLUS_ULTRA -> 1399.0;
            case ANUAL_PLATINO_PLUS_DORADA_ULTRA_MAX -> 2499.0;
        };
    }

    //Cargar datos
    @SuppressWarnings("unchecked")
    private void cargarDatos()
    {
        try
        {
            Object obj = persistencia.cargar("membresias.dat");
            if (obj != null)
            {
                membresias = (List<Membresia>) obj;
                nextId = membresias.stream()
                        .mapToInt(Membresia::getId)
                        .max()
                        .orElse(0) + 1;
            }
        } catch (PersistenciaException e)
        {
            System.err.println("Error al cargar membresias: " + e.getMessage());
        }
    }

    //Guardar datos
    private void guardarDatos()
    {
        try
        {
            persistencia.guardar("membresias.dat", membresias);
        } catch (PersistenciaException e)
        {
            System.err.println("Error al guardar membresias: " + e.getMessage());
        }
    }
}
