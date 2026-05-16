package com.example.gympos.exception;

//La excepcion base para todos los errores del sistema
public class GymPOSException extends Exception
{
    public GymPOSException(String mensaje)
    {
        super(mensaje);
    }

    public GymPOSException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
