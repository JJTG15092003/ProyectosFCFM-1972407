package Actividad06;

public class automata extends automataRobot implements EsqueletoComportamiento
{
    public automata(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        double probabilidad = Math.random();
        if(probabilidad > 0.5)
        {
            System.out.println(getNombre() + " no pudo soportar el ataque!");
            super.recibirDanio(cantidad * 1.3f);
            System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
        }
        else
        {
            System.out.println("¡SISTEMA DE DEFENSA ACTIVO! " + getNombre() + " bloqueó el ataque.");
        }
    }

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Electrico"))
        {
            System.out.println("¡El automata sufre un cortocircuito!");
            this.recibirDanio(cantidad * 1.5f); // Recibe más daño
        } else
        {
            this.recibirDanio(cantidad);
        }
    }

    // Sobrecarga 3: Daño Crítico
    public void recibirDanio(float cantidad, boolean esCritico)
    {
        if (esCritico)
        {
            System.out.println("¡HAZ IMPACTADO EN LA ZONA DEBIL DE SU CARCAZA!");
            this.recibirDanio(cantidad * 2.0f);
        } else
        {
            this.recibirDanio(cantidad);
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n > El cuerpo de " + getNombre() + " tambalea con cada intento de dar un paso...";
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " sube de nivel! y se logra reconstruir!");
        super.aumentoNivel();
        this.vida += vida * 0.5f;
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }

    @Override
    public float calcularMultiplicadorDanio()
    {
        return 1;
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return 55;
    }

    //Ataques
    @Override
    public void prepararAtaque()
    {
        System.out.println(getNombre() + " Reposiciona sus brazos mecanicos en postura de combate...");
        if (this.vida < 1000)
        {
            System.out.println("Ha cargado contra el jugador!");
        }
    }

    //Mi metodo abstracto
    @Override
    public void finalizarAccion()
    {
        System.out.println(getNombre() + " regresa a su sitio tambaleante");
    }
}