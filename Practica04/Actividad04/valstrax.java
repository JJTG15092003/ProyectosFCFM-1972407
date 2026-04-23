package Actividad04;

public class valstrax extends organico
{
    public valstrax(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        System.out.println("Las escamas de " + getNombre() + " comienzan a desquebrajarse!");
        System.out.println(getNombre() + " ha perdido " + cantidad + " puntos de salud!");
        super.recibirDanio(cantidad);
    }
    @Override
    public void recibirCura(float vida)
    {
        System.out.println(getNombre() + " ha regenerado " + vida + " puntos de vida!");
        super.recibirCura(vida);
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
    }
}
