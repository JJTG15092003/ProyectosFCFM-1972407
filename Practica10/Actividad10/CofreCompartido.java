package Actividad10;

public class CofreCompartido
{
    private final java.util.Queue<Botin> cola = new java.util.LinkedList<>();
    private final int CAPACIDAD = 5;

    public synchronized void agregarBotin(Botin b, String nombreMonstruo) throws InterruptedException
    {
        while (cola.size() == CAPACIDAD)
        {
            System.out.println("Cofre lleno. " + nombreMonstruo + " espera...");
            wait(); //El monstruo espera a que haya espacio
        }
        cola.add(b);
        System.out.println("⚔️ " + nombreMonstruo + " dejó caer: " + b);
        notifyAll(); //Avisa a los jugadores que hay botin
    }

    public synchronized Botin recogerBotin(String nombreJugador) throws InterruptedException
    {
        while (cola.isEmpty())
        {
            System.out.println("👤 " + nombreJugador + " esperando botín...");
            wait(); //El jugador espera a que caiga algo
        }
        Botin b = cola.poll();
        System.out.println("$ " + nombreJugador + " recogió: " + b);
        notifyAll(); //Avisa a los monstruos que ya hay espacio
        return b;
    }
}