package Actividad07;

public class zombie extends noMuerto implements EsqueletoComportamiento, Accion
{
    public zombie(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        super.recibirDanio(cantidad);
    }

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Fuego"))
        {
            System.out.println("¡El fuego calcina la piel necrotica del zombie!");
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
            System.out.println("¡HERIDA ABIERTA EN LOS BRAZOS!");
            this.recibirDanio(cantidad * 2.0f);
        } else
        {
            this.recibirDanio(cantidad);
        }
    }

    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " se ha fortalezido gracias al combate!");
        super.aumentoNivel();
    }

    @Override
    public String toString()
    {
        String infoBase = super.toString();
        return infoBase + "\n > Su cuerpo tambalea, su mirada ciega recae sobre ti dandote un escalofrio por la espalda...";
    }

    //Acciones de combate
    @Override
    public String atacar()
    {
        return getNombre() + " se abalanza contra el jugador con un grito desgarrador!";
    }

    @Override
    public float calcularMultiplicadorDanio()
    {
        // Los zombies no dependen de su vida
        return 1.15f;
    }

    @Override
    public int generarExperienciaAlMorir()
    {
        return this.nivel * 50; // Dan poca experiencia
    }

    @Override
    public void prepararAtaque()
    {
        System.out.println(nombre + " emite un gemido ronco y arrastra los pies...");
    }

    @Override
    public void finalizarAccion()
    {
        System.out.println(nombre + " se queda tambaleando tras el intento de mordida.");
    }
}