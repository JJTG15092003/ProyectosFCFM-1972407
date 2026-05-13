package ExcepcionesAct10;
import Actividad10.Botin;

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
