package ExcepcionesAct10;
import java.time.LocalDateTime;

public class BestiarioException extends Exception
{
    private LocalDateTime timestamp;

    public BestiarioException(String mensaje)
    {
        super(mensaje);
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }
}