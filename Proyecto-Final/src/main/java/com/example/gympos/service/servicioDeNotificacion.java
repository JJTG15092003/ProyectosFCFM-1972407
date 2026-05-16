package com.example.gympos.service;

import com.example.gympos.model.Membresia;
import com.example.gympos.controller.controladorMembresia;

import java.util.List;

public class servicioDeNotificacion
{

    private controladorMembresia controladorMembresia;
    private boolean ejecutando;
    private Thread threadMonitor;

    // Días de anticipación para notificar vencimiento
    private static final int DIAS_ANTICIPACION = 7;
    // Intervalo entre revisiones (en milisegundos): 1 hora
    private static final long INTERVALO_REVISION = 60 * 60 * 1000L;

    public servicioDeNotificacion(controladorMembresia mc)
    {
        this.controladorMembresia = mc;
        this.ejecutando = false;
    }

    public void iniciarMonitor()
    {
        ejecutando = true;
        threadMonitor = new Thread(() ->
        {
            while (ejecutando)
            {
                try
                {
                    revisarVencimientos();
                    Thread.sleep(INTERVALO_REVISION);
                } catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        threadMonitor.setDaemon(true);
        threadMonitor.setName("Thread-MonitorMembresias");
        threadMonitor.start();
    }

    public void detenerMonitor()
    {
        ejecutando = false;
        if (threadMonitor != null)
        {
            threadMonitor.interrupt();
        }
    }

    private void revisarVencimientos()
    {
        List<Membresia> proximas = controladorMembresia.obtenerProximasAVencer(DIAS_ANTICIPACION);
        for (Membresia m : proximas)
        {
            // TODO: Implementar notificación (puede ser un alert en JavaFX
            //       usando Platform.runLater, o un log en consola)
            System.out.println("[NOTIFICACION] Membresía por vencer: " + m.getCliente());
        }
    }

    public boolean isEjecutando()
    {
        return ejecutando;
    }
}
