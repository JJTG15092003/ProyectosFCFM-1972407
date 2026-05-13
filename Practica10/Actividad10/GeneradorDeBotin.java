package Actividad10;

public class GeneradorDeBotin implements Runnable
{
    private Monstruo m;
    private CofreCompartido cofre;

    public GeneradorDeBotin(Monstruo m, CofreCompartido cofre)
    {
        this.m = m;
        this.cofre = cofre;
    }

    @Override
    public void run()
    {
        try
        {
            //Simulamos la pelea del monstruo por un tiempo
            Thread.sleep((long) (Math.random() * 2000));
            cofre.agregarBotin(m.recompensa, m.getNombre());
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}