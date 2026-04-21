package Actividad03;

public class Monstruo
{
    //Mis clases privadas
    private String nombre;
    private String tipo;
    private float vida;
    private int nivel;
    private boolean esJefe;

    //Mis constructores
    public Monstruo(String nombre, String tipo, float vida, int nivel, boolean esJefe)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.nivel = nivel;
        this.esJefe = esJefe;
    }
    public Monstruo(float vida, String nombre, int nivel)
    {
        this.vida = vida;
        this.nombre = nombre;
        this.nivel = nivel;
    }
    //Mi constructor vacio
    public Monstruo()
    {
        this("Slime", "Organico", 10, 1, false);
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
