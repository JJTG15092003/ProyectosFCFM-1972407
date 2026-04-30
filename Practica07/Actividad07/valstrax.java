package Actividad07;
import Excepciones.*;


public class valstrax extends organico implements EsqueletoComportamiento, Accion
{
    private int postura = 10;
    public valstrax(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
            throws AtributoInvalidoException, RecompensaIlegalException
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    //Mi sobrecarga 1
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

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Agua"))
        {
            System.out.println("¡El agua debilita la energía dragón del Valstrax!");
            this.recibirDanio(cantidad * 1.5f); // Recibe más daño
        } else
        {
            this.recibirDanio(cantidad);
        }
    }

    // Sobrecarga 3: Daño Crítico
    public void recibirDanio(float cantidad, boolean esCritico)
    {
        if (esCritico)
        {
            System.out.println("¡GOLPE CRÍTICO EN LAS ALAS!");
            this.recibirDanio(cantidad * 2.0f);
        } else
        {
            this.recibirDanio(cantidad);
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
    public void aumentoNivel() throws AtributoInvalidoException
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

    //Acciones de combate
    @Override
    public String atacar()
    {
        return getNombre() + " ejecuta un 'Ambush' desde el cielo a velocidad supersónica!";
    }

    @Override
    public String bloquearAtaque()
    {
        return getNombre() + " endurece sus alas para mitigar el impacto.";
    }

    @Override
    public String huidaTactica()
    {
        return getNombre() + " enciende sus propulsores y desaparece en el horizonte.";
    }

    //Comportamiento basico
    @Override
    public float calcularMultiplicadorDanio()
    {
        return (this.vida < 1000) ? 2.5f : 1.5f;
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return 5000;
    }

    //Metodos abstractos
    @Override
    public void prepararAtaque()
    {
        System.out.println(getNombre() + " acumula energía dragón...");
    }

    @Override
    public void finalizarAccion()
    {
        System.out.println(getNombre() + " aterriza dejando una estela roja.");
    }
}