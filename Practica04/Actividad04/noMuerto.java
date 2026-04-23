package Actividad04;

public class noMuerto extends Monstruo
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
}