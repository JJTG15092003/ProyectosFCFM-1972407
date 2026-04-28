package Actividad05;

public class valstrax extends organico implements Interactuable
{
    private float probAmbush = 0;
    private int postura = 10;
    public valstrax(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        if(postura > 0)
        {
            System.out.println("Las escamas de " + getNombre() + " lo protegen del daño recibido!");
            super.recibirDanio(cantidad * 0.85f);
            postura -= 1;
            System.out.println(getNombre() + " ahora tiene " + vida + " puntos de salud!");
        }
        else
        {
            System.out.println(getNombre() + " no tiene postura defensiva, tu ataque impacta de lleno!");
            super.recibirDanio(cantidad * 1.2f);
            System.out.println(getNombre() + " ahora tiene " + vida + " puntos de salud!");
        }
    }
    @Override
    public void recibirCura(float vida)
    {
        System.out.println("La bioenergia del ambiente se condendas... " + getNombre() + " la absorbe y se regenera!");
        super.recibirCura(vida);
        System.out.println(getNombre() + " ahora tiene " + vida + " puntos de salud!");
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha vuelto mas fuerte! Ha subido de nivel!");
        super.aumentoNivel();
        postura += 5;
        System.out.println("La postura defensiva de " + getNombre() + " se reestablece en 5 puntos!");
    }

    @Override
    public String toString()
    {
        String infoBase = super.toString();
        return infoBase + "\n > Poder Espectral: " + postura + " almas en reserva" +
                "\n > Estado: " + (postura > 0 ? "[POSTURA DEFENSIVA ACTIVA]" : "[POSTURA DEFENSIVA AUSENTE]");
    }

    @Override
    public float calcularMultiplicadorDanio()
    {
        return (this.vida < 1000) ? 2.5f : 1.5f;
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return 0;
    }
}