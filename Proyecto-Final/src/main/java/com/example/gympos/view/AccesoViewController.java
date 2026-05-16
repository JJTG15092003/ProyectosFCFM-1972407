package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import com.example.gympos.model.Cliente;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.RegistroAcceso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

//Controlador de acceso
public class AccesoViewController
{

    @FXML
    private TableView<RegistroAcceso> tablaAccesos;
    @FXML
    private TableColumn<RegistroAcceso, Integer> colId;
    @FXML
    private TableColumn<RegistroAcceso, String> colCliente, colEntrada, colSalida, colDuracion, colActivo;

    @FXML
    private TextField txtBuscarCliente;
    @FXML
    private VBox panelInfoCliente;
    @FXML
    private Label lblNombreCliente;
    @FXML
    private Label lblEstadoMembresia;
    @FXML
    private Label lblEstadoAcceso;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblPersonasDentro;

    private Cliente clienteActual;
    private ObservableList<RegistroAcceso> listaObservable;
    private List<RegistroAcceso> registros;
    private int nextIdRegistro;

    @FXML
    public void initialize()
    {
        this.registros = MainApp.listaAccesosGlobal;
        listaObservable = FXCollections.observableArrayList(registros);
        tablaAccesos.setItems(listaObservable);
        nextIdRegistro = registros.size() + 1;
        panelInfoCliente.setVisible(false);
        configurarColumnas();
        actualizarContador();
    }

    private void configurarColumnas()
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        colCliente.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getCliente().toString()
                )
        );
        colEntrada.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getHoraEntrada().toString()
                )
        );
        colSalida.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getHoraSalida() != null
                                ? data.getValue().getHoraSalida().toString()
                                : "En gimnasio"
                )
        );
        colDuracion.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().calcularTiempoEstancia() + " min"
                )
        );
        colActivo.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().estaActivo() ? "Adentro" : "Salio"
                )
        );
    }

    @FXML
    private void handleBuscar()
    {
        String texto = txtBuscarCliente.getText().trim();
        if (texto.isEmpty())
        {
            return;
        }

        try
        {
            int id = Integer.parseInt(texto);
            MainApp.controladorCliente.buscarPorId(id).ifPresentOrElse(
                    this::mostrarInfoCliente,
                    () -> lblStatus.setText("No se encontro cliente con ID: " + id)
            );
        } catch (NumberFormatException e)
        {
            List<Cliente> resultados =
                    MainApp.controladorCliente.buscarPorNombre(texto);
            if (!resultados.isEmpty())
            {
                mostrarInfoCliente(resultados.get(0));
            } else
            {
                lblStatus.setText("No se encontro cliente: " + texto);
            }
        }
    }

    //Mostrar la informacion del cliente en el panel lateral
    private void mostrarInfoCliente(Cliente cliente)
    {
        clienteActual = cliente;
        panelInfoCliente.setVisible(true);
        lblNombreCliente.setText(cliente.getNombre() + " " + cliente.getApellido());

        Membresia m = MainApp.controladorMembresia.obtenerMembresiaActiva(cliente);
        lblEstadoMembresia.setText("Membresia: " + (m != null ? m.getTipoPlan() : "Sin membresia activa"));

        boolean dentroGym = registros.stream()
                .anyMatch(r -> r.getCliente().getId() == cliente.getId() && r.estaActivo());
        lblEstadoAcceso.setText("Estado: " + (dentroGym ? "Dentro del gimnasio" : "Fuera del gimnasio"));
    }

    @FXML
    private void handleEntrada()
    {
        if (clienteActual == null)
        {
            lblStatus.setText("Busca un cliente primero.");
            return;
        }

        boolean yaAdentro = registros.stream()
                .anyMatch(r -> r.getCliente().getId() == clienteActual.getId() && r.estaActivo());
        if (yaAdentro)
        {
            lblStatus.setText("El cliente ya esta dentro del gimnasio.");
            return;
        }

        RegistroAcceso registro = new RegistroAcceso(nextIdRegistro++, clienteActual);
        registros.add(registro);
        listaObservable.add(registro);
        lblStatus.setText("Entrada registrada.");
        lblEstadoAcceso.setText("Estado: Dentro del gimnasio");
        actualizarContador();
    }

    @FXML
    private void handleSalida()
    {
        if (clienteActual == null)
        {
            lblStatus.setText("Busca un cliente primero.");
            return;
        }

        registros.stream()
                .filter(r -> r.getCliente().getId() == clienteActual.getId() && r.estaActivo())
                .findFirst()
                .ifPresentOrElse(r ->
                {
                    r.registrarSalida();
                    listaObservable.setAll(registros);
                    lblStatus.setText("Salida registrada. Tiempo: " + r.calcularTiempoEstancia() + " min");
                    lblEstadoAcceso.setText("Estado: Fuera del gimnasio");
                }, () -> lblStatus.setText("El cliente no tiene entrada activa."));

        actualizarContador();
    }

    private void actualizarContador()
    {
        long dentro = registros.stream().filter(RegistroAcceso::estaActivo).count();
        lblPersonasDentro.setText(String.valueOf(dentro));
    }
}
