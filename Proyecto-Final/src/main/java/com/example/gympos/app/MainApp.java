package com.example.gympos.app;

import com.example.gympos.controller.controladorCliente;
import com.example.gympos.controller.controladorMembresia;
import com.example.gympos.controller.controladorPago;
import com.example.gympos.controller.controladorUsuario;
import com.example.gympos.model.RegistroAcceso; // Asegúrate de importar tu modelo
import com.example.gympos.service.servicioDeNotificacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList; //Necesario para la lista
import java.util.List;      //Necesario para la lista

//Main inicio del programa
public class MainApp extends Application
{
    public static controladorCliente controladorCliente;
    public static controladorMembresia controladorMembresia;
    public static controladorPago controladorPago;
    public static controladorUsuario controladorUsuario;
    public static servicioDeNotificacion servicioDeNotificacion;
    public static List<RegistroAcceso> listaAccesosGlobal = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        controladorCliente = new controladorCliente();
        controladorMembresia = new controladorMembresia();
        controladorPago = new controladorPago();
        controladorUsuario = new controladorUsuario();

        servicioDeNotificacion = new servicioDeNotificacion(controladorMembresia);
        servicioDeNotificacion.iniciarMonitor();

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/gympos/LoginView.fxml"));
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("GymPOS - Sistema de Punto de Venta");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception
    {
        if (servicioDeNotificacion != null)
        {
            servicioDeNotificacion.detenerMonitor();
        }
        super.stop();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}