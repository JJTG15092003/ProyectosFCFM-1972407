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
        this.vida = vida;
        this.nivel = nivel;
        this.recompensa = recompensa;
        this.esJefe = esJefe;
    }

    //Mi setter
    public void setRecompensa(Botin recompensa)
    {
        this.recompensa = recompensa;
    }

    //Mi toString
    @Override
    public String toString()
    {
        return "MONSTRUO: " + nombre + " [Nivel " + nivel + "]" +
                "\n > Status: " + (esJefe ? "JEFE" : "Normal") +
                "\n > Botín: " + recompensa; // Llama al toString de Botin
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
        this.nivel += 1;
    }
    public void evolucion(String cambio)
    {
        this.tipo = cambio;
    }
}