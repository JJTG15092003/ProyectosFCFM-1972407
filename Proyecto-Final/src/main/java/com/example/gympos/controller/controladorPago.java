package com.example.gympos.controller;

import com.example.gympos.exception.PagoException;
import com.example.gympos.exception.PersistenciaException;
import com.example.gympos.model.Cliente;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.Pago;
import com.example.gympos.model.Pago.MetodoPago;
import com.example.gympos.service.PersistenciaService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Controlador de pagos
public class controladorPago
{

    private List<Pago> pagos;
    private PersistenciaService persistencia;
    private int nextId;

    public controladorPago()
    {
        this.persistencia = new PersistenciaService();
        this.pagos = new ArrayList<>();
        this.nextId = 1;
        cargarDatos();
    }

    //Procesamiento del pago con multithreading
    public Pago procesarPago(Cliente cliente, Membresia membresia,
                             MetodoPago metodo) throws PagoException
    {
        if (cliente == null || membresia == null || metodo == null)
        {
            throw new PagoException("Datos incompletos para procesar el pago");
        }

        Pago pago = new Pago(nextId++, cliente, membresia, membresia.getPrecio(), metodo);
        pagos.add(pago);

        Thread threadPago = new Thread(() ->
        {
            try
            {
                int espera = 1000 + new Random().nextInt(2000);
                Thread.sleep(espera);
                pago.procesar();
                guardarDatos();
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                pago.setEstado(Pago.EstadoPago.RECHAZADO);
            }
        });
        threadPago.setDaemon(true);
        threadPago.setName("Thread-Pago-" + pago.getId());
        threadPago.start();

        return pago;
    }

    //Mostrar historial de pagos del cliente
    public List<Pago> obtenerHistorialCliente(Cliente cliente)
    {
        return pagos.stream()
                .filter(p -> p.getCliente().getId() == cliente.getId())
                .collect(Collectors.toList());
    }

    //Mostrar todos los pagos del sistema
    public List<Pago> obtenerTodos()
    {
        return new ArrayList<>(pagos);
    }

    //Calcular ingresos del mes
    public double calcularIngresosMesActual()
    {
        LocalDateTime inicioMes = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        return pagos.stream()
                .filter(p -> p.getEstado() == Pago.EstadoPago.COMPLETADO
                        && p.getFechaHora().isAfter(inicioMes))
                .mapToDouble(Pago::getMonto)
                .sum();
    }

    //Cargar datos
    @SuppressWarnings("unchecked")
    private void cargarDatos()
    {
        try
        {
            Object obj = persistencia.cargar("pagos.dat");
            if (obj != null)
            {
                pagos = (List<Pago>) obj;
                nextId = pagos.stream()
                        .mapToInt(Pago::getId)
                        .max()
                        .orElse(0) + 1;
            }
        } catch (PersistenciaException e)
        {
            System.err.println("Error al cargar pagos: " + e.getMessage());
        }
    }

    //Guardar datos
    private void guardarDatos()
    {
        try
        {
            persistencia.guardar("pagos.dat", pagos);
        } catch (PersistenciaException e)
        {
            System.err.println("Error al guardar pagos: " + e.getMessage());
        }
    }
}
