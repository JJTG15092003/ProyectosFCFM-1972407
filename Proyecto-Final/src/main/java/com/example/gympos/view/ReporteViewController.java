package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import com.example.gympos.service.ReporteService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class ReporteViewController
{

    @FXML
    private TextArea areaReporte;
    @FXML
    private ProgressIndicator spinnerReporte;
    @FXML
    private Label lblGenerando;
    @FXML
    private Label lblRutaArchivo;

    private ReporteService reporteService;

    @FXML
    public void initialize()
    {
        reporteService = new ReporteService(
                MainApp.controladorCliente,
                MainApp.controladorMembresia,
                MainApp.controladorPago
        );
        areaReporte.setText("Selecciona un tipo de reporte para generarlo...");
    }

    @FXML
    private void handleReporteIngresos()
    {
        iniciarGeneracion("Generando reporte de ingresos...");
        reporteService.generarReporteIngresos(new ReporteService.ReporteCallback()
        {
            @Override
            public void onReporteListo(String ruta)
            {
                // Este callback puede venir desde otro Thread → Platform.runLater
                Platform.runLater(() ->
                {
                    finalizarGeneracion(ruta);
                    // TODO: leer el archivo y mostrarlo en areaReporte
                    areaReporte.setText("Reporte generado en: " + ruta);
                });
            }

            @Override
            public void onError(String mensaje)
            {
                Platform.runLater(() ->
                {
                    spinnerReporte.setVisible(false);
                    lblGenerando.setText("Error: " + mensaje);
                });
            }
        });
    }

    @FXML
    private void handleReporteClientes()
    {
        iniciarGeneracion("Generando reporte de clientes...");
        reporteService.generarReporteClientes(new ReporteService.ReporteCallback()
        {
            @Override
            public void onReporteListo(String ruta)
            {
                Platform.runLater(() ->
                {
                    finalizarGeneracion(ruta);
                    areaReporte.setText("Reporte generado en: " + ruta);
                });
            }

            @Override
            public void onError(String mensaje)
            {
                Platform.runLater(() ->
                {
                    spinnerReporte.setVisible(false);
                    lblGenerando.setText(" X " + mensaje);
                });
            }
        });
    }

    @FXML
    private void handleBackup()
    {
        iniciarGeneracion("Realizando backup...");
        reporteService.generarBackup(new ReporteService.ReporteCallback()
        {
            @Override
            public void onReporteListo(String ruta)
            {
                Platform.runLater(() -> finalizarGeneracion(ruta));
            }

            @Override
            public void onError(String mensaje)
            {
                Platform.runLater(() ->
                {
                    spinnerReporte.setVisible(false);
                    lblGenerando.setText(" X " + mensaje);
                });
            }
        });
    }

    private void iniciarGeneracion(String mensaje)
    {
        spinnerReporte.setVisible(true);
        lblGenerando.setText(mensaje);
        lblRutaArchivo.setText("—");
        areaReporte.setText("Generando...");
    }

    private void finalizarGeneracion(String ruta)
    {
        spinnerReporte.setVisible(false);
        lblGenerando.setText("Listo.");
        lblRutaArchivo.setText(ruta);
    }
}
