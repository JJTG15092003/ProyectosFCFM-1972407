package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainViewController
{

    @FXML
    private Label lblUsuarioActual;
    @FXML
    private Label lblEstado;
    @FXML
    private TabPane tabPane;

    @FXML
    public void initialize()
    {


        lblEstado.setText("Sistema listo. " +
                MainApp.controladorCliente.obtenerTodos().size() + " clientes registrados.");
    }

    @FXML
    private void handleCerrarSesion()
    {
        // TODO: Confirmar con Alert, cerrar esta Stage, abrir LoginView
        Stage stage = (Stage) tabPane.getScene().getWindow();
        stage.close();
    }

    public void actualizarEstado(String mensaje)
    {
        lblEstado.setText(mensaje);
    }
}
