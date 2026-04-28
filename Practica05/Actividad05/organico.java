package Actividad05;

public class organico extends Monstruo implements Interactuable
{
    public organico(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, "Orgánico", vida, nivel, recompensa, esJefe);
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