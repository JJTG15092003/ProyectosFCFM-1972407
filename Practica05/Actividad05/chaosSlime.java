package Actividad05;

import java.util.Random;

public class chaosSlime extends organico implements Interactuable
{
    float vidamax = this.vida;
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
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Fuego"))
        {
            System.out.println("¡PERO NO RESULTA EFECTO! \n[Unique Skill activate: Proteccion elemental absoluta]");
            float multiplicador = 0.5f * random.nextFloat();
            float danioFinal = cantidad * multiplicador;
            super.recibirDanio(danioFinal);
        } else
        {
            float multiplicador = 0.5f * random.nextFloat();
            float danioFinal = cantidad * multiplicador;
            super.recibirDanio(danioFinal);
        }
    }

    // Sobrecarga 3: Daño Crítico
    public void recibirDanio(float cantidad, boolean esCritico)
    {
        if (esCritico)
        {
            System.out.println("¡La herida se ha cerrado instantaneamente! \n[Unique Skill activate: Proteccion anti criticos]");
            float multiplicador = 0.5f * random.nextFloat();
            float danioFinal = cantidad * multiplicador;
            super.recibirDanio(danioFinal);
        } else
        {
            float multiplicador = 0.5f * random.nextFloat();
            float danioFinal = cantidad * multiplicador;
            super.recibirDanio(danioFinal);
        }
    }

    @Override
    public void recibirCura(float vida)
    {
        System.out.println("La regeneración instantanea de " + getNombre() + " potencia su salud en " + vida + "!");
        super.recibirCura(vida * 1.25f);
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
        System.out.println("Todas las estadisticas de " + getNombre() + " aumentan exponencialmente!");
        super.recibirCura(vida += vida * 0.15f);
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }
    @Override
    public String toString()
    {
        return super.toString() + "\n > [Estado: Núcleo inestable]";
    }

    @Override
    public float calcularMultiplicadorDanio()
    {
        return (this.vida >= (this.vidamax * 0.50f) ? 2.5f : 1.75f);
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return 1000000;
    }

    //Ataques
    @Override
    public void prepararAtaque()
    {
        System.out.println(getNombre() + " Prepara su conjunto de habilidades unicas contra el jugador!");
        if (this.vida < 1000)
        {
            System.out.println("Ha cargado contra el jugador!");
        }
    }

    //Mi metodo abstracto
    @Override
    public void finalizarAccion()
    {
        System.out.println(getNombre() + " Regresa rebotando hacia su posicion anterior...");
    }
}