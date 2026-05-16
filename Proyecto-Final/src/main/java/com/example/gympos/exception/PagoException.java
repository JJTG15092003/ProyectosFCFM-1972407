package com.example.gympos.exception;

//Errores en el procesamiento de pagos como pagos rechazados o montos no validos
public class PagoException extends GymPOSException
{
    public PagoException(String mensaje)
    {
        super(mensaje);
    }

    public PagoException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
