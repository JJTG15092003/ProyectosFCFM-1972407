package ExcepcionesAct7;

import ExcepcionesAct8.BestiarioException;

public class AtributoInvalidoException extends BestiarioException
{
    private float valorErroneo;

    public AtributoInvalidoException(String mensaje, float valor)
    {
        super(mensaje);
        this.valorErroneo = valor;
    }

    public float getValorErroneo()
    {
        return valorErroneo;
    }
}