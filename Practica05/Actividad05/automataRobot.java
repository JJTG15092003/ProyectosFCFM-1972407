package Actividad05;

public class automataRobot extends Monstruo
{
    public automataRobot(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, "Constructo autónomo", vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirCura(float cantidad)
    {
        System.out.println("El cuerpo artificial de " + nombre + " es inmune a la curacion!");
    }
}