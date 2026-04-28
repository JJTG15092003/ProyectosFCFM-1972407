package Actividad05;

public class noMuerto extends Monstruo implements Interactuable
{
    public noMuerto(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, "No-muerto", vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirCura(float cantidad)
    {
        System.out.println("La carne maldecida de " + nombre + " sufre una descomposición acelerada gracias a la curación!");
        this.recibirDanio(cantidad);
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