package com.example.gympos.exception;

//Errores relacionados con membresias como las que ya estan activadas o las no encontradas
public class MembresiaException extends GymPOSException
{
    public MembresiaException(String mensaje)
    {
        super(mensaje);
    }

    public MembresiaException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
