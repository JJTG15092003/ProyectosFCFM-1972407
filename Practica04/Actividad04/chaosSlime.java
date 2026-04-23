package Actividad04;
import java.util.Random;

public class chaosSlime extends organico
{
    Random random = new Random();
    public chaosSlime(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        float multiplicador = 0.5f * random.nextFloat();
        float danioFinal = cantidad * multiplicador;
        System.out.println("El cuerpo liquido de " + getNombre() + " reacciona de manera inusual!");
        super.recibirDanio(danioFinal);
    }
    @Override
    public void recibirCura(float vida)
    {
        System.out.println("La regeneración instantanea de " + getNombre() + " potencia su salud en " + vida + "!");
        super.recibirCura(vida * 1.25f);
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
        System.out.println("Todas las estadisticas de " + getNombre() + " aumentan exponencialmente!");
        super.recibirCura(vida += vida * 0.15f);
    }
    @Override
    public String toString()
    {
        return super.toString() + "\n > [Estado: Núcleo inestable]";
    }
}