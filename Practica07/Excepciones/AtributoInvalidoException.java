package Excepciones;

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