package Actividad04;

public class lesserLich extends noMuerto
{
    public lesserLich(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        System.out.println(getNombre() + " se desvanece parcialmente. Daño reducido!");
        super.recibirDanio(cantidad * 0.8f);
    }
}