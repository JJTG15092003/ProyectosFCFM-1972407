package ExcepcionesAct7;

import ExcepcionesAct7.BestiarioException;

public class AccionInvalidaException extends BestiarioException
{
    public AccionInvalidaException(String mensaje)
    {
        super(mensaje);
    }
}