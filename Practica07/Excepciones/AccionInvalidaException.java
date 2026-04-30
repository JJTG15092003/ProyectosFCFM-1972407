package Excepciones;

public class AccionInvalidaException extends BestiarioException
{
    String accion;
    public AccionInvalidaException(String mensaje, String V)
    {
        super(mensaje);
        this.accion = V;
    }

    public String getAccionInvalida()
    {
        return accion;
    }
}