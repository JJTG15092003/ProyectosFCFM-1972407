package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import com.example.gympos.exception.ClienteException;
import com.example.gympos.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

//Controlador de la vista de gestion de clientes
public class ClienteViewController
{

    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, Integer> colId;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colApellido;
    @FXML
    private TableColumn<Cliente, String> colEmail;
    @FXML
    private TableColumn<Cliente, String> colTelefono;
    @FXML
    private TableColumn<Cliente, Integer> colPuntos;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Label lblStatus;

    private ObservableList<Cliente> listaObservable;
    private Cliente clienteSeleccionado;

    @FXML
    public void initialize()
    {
        configurarColumnas();
        cargarClientes();
        configurarSeleccionTabla();
        System.out.println("DEBUG: Clientes en lista: " + MainApp.controladorCliente.obtenerTodos().size());
    }

    //Configura el binding de columnas con propiedades del modelo
    private void configurarColumnas()
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
    }

    //Carga todos los clientes en la tabla
    private void cargarClientes()
    {
        List<Cliente> listaData = MainApp.controladorCliente.obtenerTodos();
        if (listaObservable == null)
        {
            listaObservable = FXCollections.observableArrayList();
        }
        listaObservable.setAll(listaData);
        tablaClientes.setItems(listaObservable);
        tablaClientes.refresh();
    }

    //Cuando el usuario selecciona una fila, llena el formulario
    private void configurarSeleccionTabla()
    {
        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) ->
                {
                    if (seleccionado != null)
                    {
                        clienteSeleccionado = seleccionado;
                        txtNombre.setText(seleccionado.getNombre());
                        txtApellido.setText(seleccionado.getApellido());
                        txtEmail.setText(seleccionado.getEmail());
                        txtTelefono.setText(seleccionado.getTelefono());
                    }
                }
        );
    }

    //Registra un nuevo cliente con los datos del formulario
    @FXML
    private void handleRegistrar()
    {
        // Validación básica para evitar datos nulos
        if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty())
        {
            mostrarError("Nombre y Apellido son campos obligatorios.");
            return;
        }

        try
        {
            // Usamos el controlador que ya vive en MainApp
            Cliente nuevo = MainApp.controladorCliente.registrarCliente(
                    txtNombre.getText().trim(),
                    txtApellido.getText().trim(),
                    txtEmail.getText().trim(),
                    txtTelefono.getText().trim()
            );

            cargarClientes(); // Refresca la tabla
            handleLimpiar();  // Limpia los campos
            lblStatus.setText("Cliente registrado. ID: " + nuevo.getId());
        } catch (Exception e)
        { // Cambié a Exception genérica por si el error no es solo de ClienteException
            mostrarError("Error al registrar: " + e.getMessage());
            e.printStackTrace(); // Esto te ayudará a ver en la consola si algo más falla
        }
    }

    //Actualiza el cliente seleccionado
    @FXML
    private void handleActualizar()
    {
        if (clienteSeleccionado == null)
        {
            mostrarError("Selecciona un cliente primero.");
            return;
        }
        try
        {
            clienteSeleccionado.setNombre(txtNombre.getText().trim());
            clienteSeleccionado.setApellido(txtApellido.getText().trim());
            clienteSeleccionado.setEmail(txtEmail.getText().trim());
            clienteSeleccionado.setTelefono(txtTelefono.getText().trim());
            MainApp.controladorCliente.actualizarCliente(clienteSeleccionado);
            cargarClientes();
            lblStatus.setText("Cliente actualizado correctamente.");
        } catch (ClienteException e)
        {
            mostrarError(e.getMessage());
        }
    }

    //Elimina el cliente seleccionado
    @FXML
    private void handleEliminar()
    {
        if (clienteSeleccionado == null)
        {
            mostrarError("Selecciona un cliente primero.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminacion");
        confirmacion.setHeaderText("Eliminar cliente");
        confirmacion.setContentText("¿Seguro que deseas eliminar a " + clienteSeleccionado + "?");

        confirmacion.showAndWait().ifPresent(respuesta ->
        {
            if (respuesta == ButtonType.OK)
            {
                try
                {
                    MainApp.controladorCliente.eliminarCliente(clienteSeleccionado.getId());
                    cargarClientes();
                    handleLimpiar();
                    lblStatus.setText("Cliente eliminado.");
                } catch (ClienteException e)
                {
                    mostrarError(e.getMessage());
                }
            }
        });
    }

    //Filtra la tabla segun el texto de busqueda
    @FXML
    private void handleBuscar()
    {
        String texto = txtBuscar.getText().trim();
        if (texto.isEmpty())
        {
            cargarClientes();
            return;
        }
        listaObservable.setAll(MainApp.controladorCliente.buscarPorNombre(texto));
    }

    //Muestra todos los clientes sin filtro
    @FXML
    private void handleMostrarTodos()
    {
        cargarClientes();
        txtBuscar.clear();
        lblStatus.setText("");
    }

    //Limpia el formulario y deselecciona la tabla
    @FXML
    private void handleLimpiar()
    {
        txtNombre.clear();
        txtApellido.clear();
        txtEmail.clear();
        txtTelefono.clear();
        clienteSeleccionado = null;
        tablaClientes.getSelectionModel().clearSelection();
        lblStatus.setText("");
    }

    private void mostrarError(String mensaje)
    {
        lblStatus.setText(mensaje);
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
