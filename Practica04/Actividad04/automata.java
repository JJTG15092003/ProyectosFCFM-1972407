package Actividad04;

public class automata extends automataRobot
{
    public automata(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        System.out.println("El cuerpo robótico de " + getNombre() + " se cae a pedazos!");
        System.out.println(getNombre() + " ha perdido " + cantidad + " puntos de salud!");
        super.recibirDanio(cantidad);
    }
    @Override
    public void recibirCura(float vida)
    {
        System.out.println(getNombre() + " ha reunido sus partes faltantes y se ha reconstruido!");
        System.out.println(getNombre() + " ha regenerado " + vida + " puntos de salud!");
        super.recibirCura(vida);
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
    }
}