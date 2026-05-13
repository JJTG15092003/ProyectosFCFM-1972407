package Actividad10;

public class Jugador implements Runnable
{
    private String nombre;
    private CofreCompartido cofre;

    public Jugador(String nombre, CofreCompartido cofre)
    {
        this.nombre = nombre;
        this.cofre = cofre;
    }

    @Override
    public void run()
    {
        try
        {
            //El jugador intenta farmear botin continuamente
            while (!Thread.currentThread().isInterrupted())
            {
                //recogerBotin a synchronized y wait
                Botin botinRecogido = cofre.recogerBotin(nombre);

                //Simulamos que el jugador se anda equipando las cosas
                Thread.sleep((long) (Math.random() * 3000));
            }
        } catch (InterruptedException e)
        {
            System.out.println("ALTO " + nombre + " se ha desconectado del servidor.");
            Thread.currentThread().interrupt();
        }
    }
}