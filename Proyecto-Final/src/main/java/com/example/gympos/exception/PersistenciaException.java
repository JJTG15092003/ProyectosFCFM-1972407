package com.example.gympos.exception;

//Errores en operaciones de lectura y/o escritura de archivos
public class PersistenciaException extends GymPOSException
{
    public PersistenciaException(String mensaje)
    {
        super(mensaje);
    }

    public PersistenciaException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
