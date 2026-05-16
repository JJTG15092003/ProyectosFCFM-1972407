package com.example.gympos.service;

import com.example.gympos.controller.controladorCliente;
import com.example.gympos.controller.controladorMembresia;
import com.example.gympos.controller.controladorPago;
import com.example.gympos.exception.PersistenciaException;
import com.example.gympos.model.Cliente;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.Pago;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Servicio para generacion de reportes en threads separados
public class ReporteService
{

    private controladorCliente controladorCliente;
    private controladorMembresia controladorMembresia;
    private controladorPago controladorPago;
    private PersistenciaService persistencia;

    public interface ReporteCallback
    {
        void onReporteListo(String rutaArchivo);

        void onError(String mensaje);
    }

    public ReporteService(controladorCliente cc, controladorMembresia mc, controladorPago pc)
    {
        this.controladorCliente = cc;
        this.controladorMembresia = mc;
        this.controladorPago = pc;
        this.persistencia = new PersistenciaService();
    }

    //Genera reporte de ingresos en un thread separado
    public void generarReporteIngresos(ReporteCallback callback)
    {
        Thread thread = new Thread(() ->
        {
            try
            {
                String reporte = construirReporteIngresos();
                persistencia.exportarTexto("reporte_ingresos.txt", reporte);
                callback.onReporteListo("data/reporte_ingresos.txt");
            } catch (PersistenciaException e)
            {
                callback.onError("Error al guardar el reporte: " + e.getMessage());
            }
        });
        thread.setDaemon(true);
        thread.setName("Thread-ReporteIngresos");
        thread.start();
    }

    //Genera reporte de clientes activos en un thread separado
    public void generarReporteClientes(ReporteCallback callback)
    {
        Thread thread = new Thread(() ->
        {
            try
            {
                String reporte = construirReporteClientes();
                persistencia.exportarTexto("reporte_clientes.txt", reporte);
                callback.onReporteListo("data/reporte_clientes.txt");
            } catch (PersistenciaException e)
            {
                callback.onError("Error al guardar el reporte: " + e.getMessage());
            }
        });
        thread.setDaemon(true);
        thread.setName("Thread-ReporteClientes");
        thread.start();
    }

    //Genera backup de todos los datos en un thread separado
    public void generarBackup(ReporteCallback callback)
    {
        Thread thread = new Thread(() ->
        {
            try
            {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                String nombreBackup = "backup_" + timestamp + ".txt";

                StringBuilder sb = new StringBuilder();
                sb.append(construirReporteClientes());
                sb.append("\n\n");
                sb.append(construirReporteIngresos());

                persistencia.exportarTexto(nombreBackup, sb.toString());
                callback.onReporteListo("data/" + nombreBackup);
            } catch (PersistenciaException e)
            {
                callback.onError("Error al generar backup: " + e.getMessage());
            }
        });
        thread.setDaemon(true);
        thread.setName("Thread-Backup");
        thread.start();
    }

    //Construye el texto del reporte de ingresos
    private String construirReporteIngresos()
    {
        StringBuilder sb = new StringBuilder();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        sb.append("=== REPORTE DE INGRESOS ===\n");
        sb.append("Generado: ").append(fecha).append("\n");
        sb.append("---------------------------\n\n");

        List<Pago> pagos = controladorPago.obtenerTodos();
        double totalMes = controladorPago.calcularIngresosMesActual();
        double totalGeneral = pagos.stream()
                .filter(p -> p.getEstado() == Pago.EstadoPago.COMPLETADO)
                .mapToDouble(Pago::getMonto)
                .sum();

        sb.append("Total de pagos registrados: ").append(pagos.size()).append("\n");
        sb.append("Ingresos del mes actual: $").append(String.format("%.2f", totalMes)).append("\n");
        sb.append("Ingresos totales: $").append(String.format("%.2f", totalGeneral)).append("\n\n");

        sb.append("--- Detalle de pagos ---\n");
        for (Pago p : pagos)
        {
            sb.append("ID: ").append(p.getId())
                    .append(" | Cliente: ").append(p.getCliente())
                    .append(" | Monto: $").append(String.format("%.2f", p.getMonto()))
                    .append(" | Estado: ").append(p.getEstado())
                    .append(" | Metodo: ").append(p.getMetodoPago())
                    .append("\n");
        }

        return sb.toString();
    }

    //Construye el texto del reporte de clientes
    private String construirReporteClientes()
    {
        StringBuilder sb = new StringBuilder();
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        sb.append("=== REPORTE DE CLIENTES ===\n");
        sb.append("Generado: ").append(fecha).append("\n");
        sb.append("---------------------------\n\n");

        List<Cliente> clientes = controladorCliente.obtenerTodos();
        List<Membresia> membresias = controladorMembresia.obtenerTodas();

        long activas = membresias.stream().filter(Membresia::isActiva).count();

        sb.append("Total de clientes: ").append(clientes.size()).append("\n");
        sb.append("Membresias activas: ").append(activas).append("\n\n");

        sb.append("--- Listado de clientes ---\n");
        for (Cliente c : clientes)
        {
            Membresia m = controladorMembresia.obtenerMembresiaActiva(c);
            sb.append("ID: ").append(c.getId())
                    .append(" | ").append(c.getNombre()).append(" ").append(c.getApellido())
                    .append(" | Email: ").append(c.getEmail())
                    .append(" | Membresia: ").append(m != null ? m.getTipoPlan() : "Sin membresia")
                    .append("\n");
        }

        return sb.toString();
    }
}
