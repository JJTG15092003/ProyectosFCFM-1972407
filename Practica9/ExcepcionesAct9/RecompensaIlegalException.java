package ExcepcionesAct9;
import Actividad09.Botin;

public class RecompensaIlegalException extends BestiarioException
{
    private Botin miBotin;
    public RecompensaIlegalException(String mensaje, Botin botinN)
    {
        super(mensaje);
        this.miBotin = botinN;
    }

    public Botin getRecompensaIlegal()
    {
        return miBotin;
    }
}
