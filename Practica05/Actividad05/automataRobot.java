package Actividad05;

public class automataRobot extends Monstruo implements Interactuable
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

    @Override
    public void prepararAtaque() {

    }

    @Override
    public void finalizarAccion() {

    }

    @Override
    public float calcularMultiplicadorDanio() {
        return 0;
    }

    @Override
    public int generarExperienciaAlMorir() {
        return 0;
    }
}