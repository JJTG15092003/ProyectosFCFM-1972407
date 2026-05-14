package com.example.practica11;
import javafx.beans.property.*;

public class Monstruo
{
    //Datos basicos del Monstruo
    //Uso el Property para poder cambiar a tiempo real los datos sin refrescarlos manualmente
    private final StringProperty nombre = new SimpleStringProperty();
    private final IntegerProperty nivel = new SimpleIntegerProperty();
    private final DoubleProperty vida = new SimpleDoubleProperty();

    //Creacion de mi constructor de Monstruo
    public Monstruo(String nombre, int nivel, double vida)
    {
        this.nombre.set(nombre);
        this.nivel.set(nivel);
        this.vida.set(vida);
    }

    //Getters de los Monstruos
    public StringProperty nombreProperty() { return nombre; }
    public IntegerProperty nivelProperty() { return nivel; }
    public DoubleProperty vidaProperty() { return vida; }

    public String getNombre() { return nombre.get(); }
}