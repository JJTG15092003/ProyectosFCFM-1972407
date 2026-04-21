package Actividad03;

public class Monstruo
{
    //Mis privados
    private String nombre;
    private String tipo;
    private float vida;
    private int nivel;
    private Botin recompensa;
    private boolean esJefe;

    //Mi constructor
    public Monstruo(String nombre, String tipo, float vida, int nivel, Botin recompensa, boolean esJefe) {
        this.nombre = nombre;
        this.tipo = tipo;
        setVida(vida);
        setNivel(nivel);
        setRecompensa(recompensa);
        this.esJefe = esJefe;
    }

    //Mis setter
    public void setRecompensa(Botin recompensa)
    {
        // REGLA DE VALIDACIÓN: Un JEFE no puede tener una recompensa vacía (null)
        if (this.esJefe && recompensa == null)
        {
            System.out.println("¡Error! Un Jefe siempre debe soltar algo valioso.");
        } else
        {
            this.recompensa = recompensa;
        }
    }
    public void setNivel(int nivel)
    {
        if (nivel >= 1)
        {
            this.nivel = nivel;
        } else
        {
            System.out.println("Nivel fuera de rango!");
        }
    }
    public void setVida(float vida)
    {
        if (vida >= 0)
        {
            this.vida = vida;
        }
        else
        {
            System.out.println("Vida no puede ser inferior a 1!");
        }
    }

    //Mi toString
    @Override
    public String toString()
    {
        return "MONSTRUO: " + nombre + " [Nivel " + nivel + "]" +
                "\n > Status: " + (esJefe ? "JEFE" : "Normal") +
                "\n > Botín: " + recompensa; // Llama al toString de Botin
    }

    //Mis getter
    public boolean isEsJefe()
    {
        return esJefe;
    }
    public String getNombre()
    {
        return nombre;
    }

    //Mis metodos
    public void recibirCura(float cantidad)
    {
        this.vida += cantidad;
    }
    public void recibirDanio(float cantidad)
    {
        this.vida -= cantidad;
    }
    public void aumentoNivel()
    {
        setNivel(this.nivel + 1);
    }
    public void evolucion(String cambio)
    {
        this.tipo = cambio;
    }
}