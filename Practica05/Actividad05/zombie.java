package Actividad05;

public class zombie extends noMuerto
{
    public zombie(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        System.out.println("El cuerpo putrefacto de " + getNombre() + " comienza a descomponerse!");
        super.recibirDanio(cantidad);
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }

    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha fortalezido gracias al combate!");
        super.aumentoNivel();
    }

    @Override
    public String toString()
    {
        String infoBase = super.toString();
        return infoBase + "\n > Su cuerpo tambalea, su mirada ciega recae sobre ti dandote un escalofrio por la espalda...";
    }
}