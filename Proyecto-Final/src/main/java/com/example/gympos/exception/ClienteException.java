package com.example.gympos.exception;

//Errores relacionado con operaciones de clientes como correos duplicados o clientes no encontrados
public class ClienteException extends GymPOSException
{
    public ClienteException(String mensaje)
    {
        super(mensaje);
    }

    public ClienteException(String mensaje, Throwable causa)
    {
        super(mensaje, causa);
    }
}
