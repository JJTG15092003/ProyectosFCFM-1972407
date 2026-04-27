package Actividad05;

public class lesserLich extends noMuerto
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
}