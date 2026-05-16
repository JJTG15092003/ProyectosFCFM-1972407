package com.example.gympos.view;

import com.example.gympos.app.MainApp;
import com.example.gympos.exception.MembresiaException;
import com.example.gympos.model.Cliente;
import com.example.gympos.model.Membresia;
import com.example.gympos.model.Membresia.TipoPlan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Controlador de la vista de Membresias
public class MembresiaViewController
{

    @FXML
    private TableView<Membresia> tablaMembresias;
    @FXML
    private TableColumn<Membresia, Integer> colId;
    @FXML
    private TableColumn<Membresia, String> colCliente;
    @FXML
    private TableColumn<Membresia, TipoPlan> colPlan;
    @FXML
    private TableColumn<Membresia, Double> colPrecio;
    @FXML
    private TableColumn<Membresia, String> colInicio;
    @FXML
    private TableColumn<Membresia, String> colVencimiento;
    @FXML
    private TableColumn<Membresia, Boolean> colActiva;

    @FXML
    private TextField txtIdCliente;
    @FXML
    private ComboBox<TipoPlan> comboPlan;
    @FXML
    private ComboBox<String> comboFiltro;
    @FXML
    private TextField txtDescuento;
    @FXML
    private Label lblPrecioCalculado;
    @FXML
    private Label lblStatus;

    private ObservableList<Membresia> listaObservable;

    @FXML
    public void initialize()
    {
        comboPlan.setItems(FXCollections.observableArrayList(TipoPlan.values()));
        comboFiltro.setItems(FXCollections.observableArrayList("Todas", "Activas", "Vencidas", "Por vencer"));
        configurarColumnas();
        cargarMembresias();

        //Actualizar precio al cambiar el plan o el descuento
        comboPlan.setOnAction(e -> actualizarPrecioCalculado());
        txtDescuento.textProperty().addListener((obs, ant, nuevo) -> actualizarPrecioCalculado());
    }

    //Configura el binding de columnas
    private void configurarColumnas()
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPlan.setCellValueFactory(new PropertyValueFactory<>("tipoPlan"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colActiva.setCellValueFactory(new PropertyValueFactory<>("activa"));

        colCliente.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getCliente().toString()
                )
        );
        colInicio.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getFechaInicio().toString()
                )
        );
        colVencimiento.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getFechaVencimiento().toString()
                )
        );
    }

    private void cargarMembresias()
    {
        listaObservable = FXCollections.observableArrayList(MainApp.controladorMembresia.obtenerTodas());
        tablaMembresias.setItems(listaObservable);
    }

    //Recalcula el precio segun plan y descuento
    private void actualizarPrecioCalculado()
    {
        TipoPlan plan = comboPlan.getValue();
        if (plan == null)
        {
            return;
        }
        double precioBase = MainApp.controladorMembresia.calcularPrecio(plan);
        try
        {
            double descuento = txtDescuento.getText().isBlank() ? 0 : Double.parseDouble(txtDescuento.getText());
            double final_ = precioBase - (precioBase * (descuento / 100.0));
            lblPrecioCalculado.setText(String.format("$%.2f", final_));
        } catch (NumberFormatException e)
        {
            lblPrecioCalculado.setText("Descuento invalido");
        }
    }

    @FXML
    private void handleCrear()
    {
        String idTexto = txtIdCliente.getText().trim();
        TipoPlan plan = comboPlan.getValue();

        if (idTexto.isEmpty() || plan == null)
        {
            lblStatus.setText("Completa el ID del cliente y el plan.");
            return;
        }

        try
        {
            int idCliente = Integer.parseInt(idTexto);
            Optional<Cliente> cliente = MainApp.controladorCliente.buscarPorId(idCliente);

            if (cliente.isEmpty())
            {
                lblStatus.setText("No se encontro el cliente con ID: " + idCliente);
                return;
            }

            double descuento = txtDescuento.getText().isBlank() ? 0 : Double.parseDouble(txtDescuento.getText());
            MainApp.controladorMembresia.crearMembresia(cliente.get(), plan, descuento);
            lblStatus.setText("Membresia creada correctamente.");
            cargarMembresias();
        } catch (NumberFormatException e)
        {
            lblStatus.setText("ID o descuento invalido.");
        } catch (MembresiaException e)
        {
            lblStatus.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleRenovar()
    {
        Membresia seleccionada = tablaMembresias.getSelectionModel().getSelectedItem();
        if (seleccionada == null)
        {
            lblStatus.setText("Selecciona una membresia primero.");
            return;
        }
        try
        {
            MainApp.controladorMembresia.renovarMembresia(seleccionada.getId());
            lblStatus.setText("Membresia renovada.");
            cargarMembresias();
        } catch (MembresiaException e)
        {
            lblStatus.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void handleFiltrar()
    {
        String filtro = comboFiltro.getValue();
        if (filtro == null)
        {
            return;
        }

        List<Membresia> todas = MainApp.controladorMembresia.obtenerTodas();

        List<Membresia> filtradas = switch (filtro)
        {
            case "Activas" -> todas.stream()
                    .filter(m -> m.isActiva() && !m.estaVencida())
                    .collect(Collectors.toList());
            case "Vencidas" -> todas.stream()
                    .filter(Membresia::estaVencida)
                    .collect(Collectors.toList());
            case "Por vencer" -> MainApp.controladorMembresia.obtenerProximasAVencer(7);
            default -> todas;
        };

        listaObservable.setAll(filtradas);
    }

    @FXML
    private void handleMostrarTodas()
    {
        cargarMembresias();
    }
}
