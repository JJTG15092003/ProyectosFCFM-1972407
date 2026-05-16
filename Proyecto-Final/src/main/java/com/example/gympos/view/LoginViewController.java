package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Controlador de la vista de Login
public class LoginViewController
{

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblError;

    @FXML
    private void handleLogin()
    {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText();

        if (username.isEmpty() || password.isEmpty())
        {
            lblError.setText("Completa todos los campos.");
            return;
        }

        boolean autenticado = MainApp.controladorUsuario.autenticar(username, password);

        if (autenticado)
        {
            try
            {
                abrirPantallaPrincipal();
            } catch (Exception e)
            {
                e.printStackTrace();
                lblError.setText("Error: " + e.getMessage());
            }
        } else
        {
            lblError.setText("Usuario o contrasena incorrectos.");
        }
    }

    @FXML
    private void handleLimpiar()
    {
        txtUsername.clear();
        txtPassword.clear();
        lblError.setText("");
    }

    //Abrir la pantalla principal tras autenticacion exitosa
    private void abrirPantallaPrincipal() throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/gympos/MainView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("GymPOS - Panel Principal");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();

        Stage loginStage = (Stage) txtUsername.getScene().getWindow();
        loginStage.close();
    }
}
