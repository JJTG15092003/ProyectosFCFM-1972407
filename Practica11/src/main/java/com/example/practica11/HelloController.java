package com.example.practica11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController
{

    //Nos traemos los componentes del FXML
    @FXML private TableView<Monstruo> tablaMonstruos;
    @FXML private TableColumn<Monstruo, String> colNombre;
    @FXML private TableColumn<Monstruo, Integer> colNivel;
    @FXML private TableColumn<Monstruo, Double> colVida;
    @FXML private TextField filtroNombre;
    @FXML private TextField txtNombre, txtNivel, txtVida;

    private final ObservableList<Monstruo> listaMaestra = FXCollections.observableArrayList();

    @FXML
    private Button btnAgregar;

    @FXML
    public void initialize()
    {
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colNivel.setCellValueFactory(cellData -> cellData.getValue().nivelProperty().asObject());

        //Le añado una barra de vida en lugar de puro texto
        colVida.setCellValueFactory(cellData -> cellData.getValue().vidaProperty().asObject());
        colVida.setCellFactory(column -> new TableCell<>()
        {
            private final HealthBar hb = new HealthBar();

            @Override
            protected void updateItem(Double vida, boolean empty)
            {
                super.updateItem(vida, empty);
                if (empty || vida == null)
                {
                    setGraphic(null);
                } else
                {
                    //Voy a considerar 5000 de vida el maximo. Cualquiera por debajo tiene "poca vida"
                    hb.setSalud(vida, 5000.0);
                    setGraphic(hb);
                }
            }
        });

        FilteredList<Monstruo> listaFiltrada = new FilteredList<>(listaMaestra, p -> true);
        filtroNombre.textProperty().addListener((observable, oldValue, newValue) ->
        {
            listaFiltrada.setPredicate(monstruo ->
            {
                if (newValue == null || newValue.isEmpty()) return true;
                return monstruo.getNombre().toLowerCase().contains(newValue.toLowerCase());
            });
        });
        tablaMonstruos.setItems(listaFiltrada);

        //Validaciones en tiempo real
        btnAgregar.disableProperty().bind(
                txtNombre.textProperty().isEmpty()
                        .or(txtNivel.textProperty().isEmpty())
                        .or(txtVida.textProperty().isEmpty())
        );

        // Datos de prueba
        listaMaestra.add(new Monstruo("Valstrax", 50, 1500.0));
        listaMaestra.add(new Monstruo("Zombi", 5, 500.0));
        listaMaestra.add(new Monstruo("Chaos Slime",75, 5000.0));
        listaMaestra.add(new Monstruo("Conejo", 999, 3500.0));
    }

    //Manejo de eventos
    //Creacion de nuevo mostruo
    @FXML
    protected void onAgregarClick()
    {
        try
        {
            String nombre = txtNombre.getText();
            int nivel = Integer.parseInt(txtNivel.getText());
            double vida = Double.parseDouble(txtVida.getText());

            if (!nombre.isEmpty())
            {
                //Agrego los datos del nuevo monstruo a mi lista
                listaMaestra.add(new Monstruo(nombre, nivel, vida));
                limpiarFormulario();
            }
        } catch (NumberFormatException e)
        {
            System.out.println("ERRO! Introduce numeros validos");
        }
    }

    //Eliminacion del Monstruo seleccionado
    @FXML
    protected void onEliminarClick()
    {
        Monstruo seleccionado = tablaMonstruos.getSelectionModel().getSelectedItem();
        //Confirmacion al eliminar el monstruo
        if (seleccionado != null)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar eliminacion");
            alert.setHeaderText("Vas a eliminar a: " + seleccionado.getNombre());
            alert.setContentText("¿Estas seguro? Esta accion no se puede deshacer!");

            if (alert.showAndWait().get() == ButtonType.OK)
            {
                listaMaestra.remove(seleccionado);
            }
        }
    }

    //Mensaje de carga de archivos (Realmente no hace nada, pero aqui deberian cargarse para un simulador de peleas)
    //como el de la practica anterior
    @FXML
    protected void onCargarDatosClick()
    {
        System.out.println("Cargando datos desde archivo...");
    }

    //Salir del programa
    @FXML
    protected void onSalirClick()
    {
        System.exit(0);
    }

    //Una vez que se añade el nuevo monstruo, esta funcion limpia las barras de texto para poder agregar nueva
    //informacion
    private void limpiarFormulario()
    {
        txtNombre.clear();
        txtNivel.clear();
        txtVida.clear();
    }
}