package Actividad04;

public class chaosSlime extends organico
{
    public chaosSlime(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        System.out.println("El cuerpo gelatinoso de " + getNombre() + " empieza a derretirse!");
        System.out.println(getNombre() + " ha perdido " + cantidad + " puntos de salud!");
        super.recibirDanio(cantidad);
    }
    @Override
    public void recibirCura(float vida)
    {
        System.out.println("El cuerpo gelatinoso de " + getNombre() + " se ha regenerado!");
        System.out.println(getNombre() + " ha regenerado " + vida + " puntos de salud!");
        super.recibirCura(vida);
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
    }
}