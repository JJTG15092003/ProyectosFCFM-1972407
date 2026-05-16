package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.Pago;
import com.example.gympos.model.Pago.MetodoPago;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PagoViewController
{

    @FXML
    private TableView<Pago> tablaPagos;
    @FXML
    private TableColumn<Pago, Integer> colId;
    @FXML
    private TableColumn<Pago, String> colCliente, colMetodo, colEstado, colFechaHora;
    @FXML
    private TableColumn<Pago, Double> colMonto;

    @FXML
    private TextField txtIdCliente;
    @FXML
    private ComboBox<Membresia> comboMembresia;
    @FXML
    private ComboBox<MetodoPago> comboMetodo;
    @FXML
    private Label lblMonto;
    @FXML
    private Label lblIngresosMes;
    @FXML
    private Label lblTotalPagos;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblProcesando;
    @FXML
    private ProgressIndicator spinnerPago;

    private ObservableList<Pago> listaObservable;

    @FXML
    public void initialize()
    {
        comboMetodo.setItems(FXCollections.observableArrayList(MetodoPago.values()));
        cargarPagos();
        // TODO: configurar columnas
    }

    private void cargarPagos()
    {
        listaObservable = FXCollections.observableArrayList(MainApp.controladorPago.obtenerTodos());
        tablaPagos.setItems(listaObservable);
        lblIngresosMes.setText("$" + MainApp.controladorPago.calcularIngresosMesActual());
        lblTotalPagos.setText(String.valueOf(listaObservable.size()));
    }

    @FXML
    private void handleProcesar()
    {
        // TODO: Leer cliente y membresía seleccionados
        MetodoPago metodo = comboMetodo.getValue();
        if (metodo == null)
        {
            lblStatus.setText("Selecciona un método de pago.");
            return;
        }

        // Mostrar spinner ANTES de lanzar el Thread
        spinnerPago.setVisible(true);
        lblProcesando.setVisible(true);
        lblProcesando.setText("Procesando pago...");

        // Thread para no bloquear la UI
        Thread thread = new Thread(() ->
        {
            try
            {
                // TODO: Llamar MainApp.controladorPago.procesarPago(cliente, membresia, metodo)
                Thread.sleep(2000); // simula latencia

                // Regresar al hilo de JavaFX para actualizar UI
                Platform.runLater(() ->
                {
                    spinnerPago.setVisible(false);
                    lblProcesando.setVisible(false);
                    lblStatus.setText("Pago procesado exitosamente.");
                    cargarPagos();
                });
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            } catch (Exception e)
            {
                Platform.runLater(() ->
                {
                    spinnerPago.setVisible(false);
                    lblProcesando.setVisible(false);
                    lblStatus.setText("Error: " + e.getMessage());
                });
            }
        });
        thread.setDaemon(true);
        thread.setName("Thread-ProcesarPago");
        thread.start();
    }
}
