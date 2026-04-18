public class Monstruo
{
    //Los atributos del monstruo
    private String nombre;
    private String tipo;
    private int nivel;
    private int vidaActual;
    private boolean esJefe;

    //Constructor
    //Monstruo - datos completos
    public Monstruo(String nombre, String tipo, int nivel, int vidaActual, boolean esJefe)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vidaActual = vidaActual;
        this.esJefe = esJefe;
    }
    //Monstruo - datos basicos
    public Monstruo(String nombre, String tipo)
    {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    //Constructor vacio (El tipo por defecto)
    public Monstruo()
    {
        this("Desconocido", "Slime", 1, 10, false);
    }

    //Metodos
    public void mostrarInfo()
    {
        System.out.println("[" + tipo + "] " + nombre + " - LVL: " + nivel + " - HP: " + vidaActual);
    }
    public void recibirDanio()
    {
        this.vidaActual -= cantidad;
        System.out.println(nombre + " recibio " + cantidad + " de daño!");
    }
    public void recibirCura()
    {
        this.vidaActual += cantidad;
        System.out.println(nombre + " ha aumentado su salud en: " + cantidad + "!");
    }
    public void subidaDeNivel()
    {
        this.nivel += 1;
        System.out.println(nombre + " ha subido de nivel!");
    }
    public void evolucion()
    {
        this.tipo = nuevoTipo;
        System.out.println(nombre + " ha evolucionado en: " + nuevoTipo + "!");
    }
}
