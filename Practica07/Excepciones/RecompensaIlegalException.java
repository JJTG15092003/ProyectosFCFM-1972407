package Excepciones;

public class RecompensaIlegalException extends BestiarioException
{
    String Recompensa;
    public RecompensaIlegalException(String mensaje, String V)
    {
        super(mensaje);
        this.Recompensa = V;
    }

    public String getRecompensaInvalida()
    {
        return Recompensa;
    }
}
