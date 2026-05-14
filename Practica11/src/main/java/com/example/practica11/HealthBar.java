package com.example.practica11;

import javafx.scene.control.ProgressBar;

public class HealthBar extends ProgressBar
{

    public HealthBar()
    {
        //Tamaño predeterminado
        this.setPrefWidth(100);
        actualizarColor(0);
    }

    public void setSalud(double actual, double maxima)
    {
        double porcentaje = actual / maxima;
        this.setProgress(porcentaje);
        actualizarColor(porcentaje);
    }

    private void actualizarColor(double porcentaje)
    {
        //Estilo basado en el porcentaje
        if (porcentaje <= 0.2)
        {
            this.setStyle("-fx-accent: red;");    //Vida critica
        } else if (porcentaje <= 0.5)
        {
            this.setStyle("-fx-accent: orange;"); //Vida media
        } else
        {
            this.setStyle("-fx-accent: green;");  //Vida a tope
        }
    }
}