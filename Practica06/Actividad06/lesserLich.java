package Actividad06;

public class lesserLich extends noMuerto implements EsqueletoComportamiento
{
    private int almasAtrapadas = 0;
    public lesserLich(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        if(almasAtrapadas > 0)
        {
            System.out.println("El escudo de almas de " + getNombre() + " lo protege del daño!");
            almasAtrapadas = almasAtrapadas - 1;

        }
        else
        {
            System.out.println("El cuerpo espectral de " + getNombre() + " comienza a desaparecer!");
            super.recibirDanio(cantidad);
            System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
        }
    }

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Fuego"))
        {
            System.out.println("¡El fuego calcina la piel necrotica del lich!");
            if(almasAtrapadas > 0)
            {
                System.out.println("El escudo de almas de " + getNombre() + " lo protege del daño!");
                almasAtrapadas = almasAtrapadas - 3;

            }
            else
            {
                System.out.println("El cuerpo espectral de " + getNombre() + " comienza a desaparecer!");
                super.recibirDanio(cantidad * 1.5f);
                System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
            }
        } else
        {
            if(almasAtrapadas > 0)
            {
                System.out.println("El escudo de almas de " + getNombre() + " lo protege del daño!");
                almasAtrapadas = almasAtrapadas - 1;

            }
            else
            {
                System.out.println("El cuerpo espectral de " + getNombre() + " comienza a desaparecer!");
                super.recibirDanio(cantidad);
                System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
            }
        }
    }

    // Sobrecarga 3: Daño Crítico
    public void recibirDanio(float cantidad, boolean esCritico)
    {
        if (esCritico)
        {
            System.out.println("¡HERIDA ABIERTA EN LOS BRAZOS!");
            if(almasAtrapadas > 0)
            {
                System.out.println("El escudo de almas de " + getNombre() + " lo protege del daño!");
                almasAtrapadas = almasAtrapadas - 3;

            }
            else
            {
                System.out.println("El cuerpo espectral de " + getNombre() + " comienza a desaparecer!");
                super.recibirDanio(cantidad * 2.5f);
                System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
            }
        } else
        {
            if(almasAtrapadas > 0)
            {
                System.out.println("El escudo de almas de " + getNombre() + " lo protege del daño!");
                almasAtrapadas = almasAtrapadas - 1;

            }
            else
            {
                System.out.println("El cuerpo espectral de " + getNombre() + " comienza a desaparecer!");
                super.recibirDanio(cantidad);
                System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
            }
        }
    }

    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " aumenta de nivel tras su enfrentamiento!");
        super.aumentoNivel();
        System.out.println(getNombre() + " tiene ahora " + this.nivel + " nivel/es!");
        almasAtrapadas += 5;
    }

    @Override
    public String toString()
    {
        String infoBase = super.toString();
        return infoBase + "\n > Poder Espectral: " + almasAtrapadas + " almas en reserva" +
                "\n > Estado: " + (almasAtrapadas > 0 ? "[ESCUDO ACTIVADO]" : "[ESCUDO DESACTIVADO]");
    }

    @Override
    public float calcularMultiplicadorDanio()
    {
        return (this.almasAtrapadas >= 5) ? 1.7f : 1f;
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return (this.nivel) * 2;
    }

    //Ataques
    @Override
    public void prepararAtaque()
    {
        System.out.println(getNombre() + " Prepara sus hechizos desde su grimorio");
        if (this.vida < 1000)
        {
            System.out.println("Ha cargado contra el jugador!");
        }
    }

    //Mi metodo abstracto
    @Override
    public void finalizarAccion()
    {
        System.out.println(getNombre() + " Guarda su grimorio en su bolso necrotico");
    }
}