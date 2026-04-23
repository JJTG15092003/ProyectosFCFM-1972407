package Actividad04;

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
    }

    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha fortalezido gracias al combate!");
        this.vida += 20;
        System.out.println("La salud de" + getNombre() + " ha invrementado en 20 puntos debido a su aumento de nivel!");
    }

    @Override
    public String toString()
    {
        String infoBase = super.toString();
        return infoBase + " Su cuerpo tambalea, su mirada ciega recae sobre ti dandote un escalofrio por la espalda...";
    }
}