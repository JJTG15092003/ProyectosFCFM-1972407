package Actividad07;
import Excepciones.*;

public abstract class Monstruo implements EsqueletoComportamiento
{
    //Mis privados
    protected String nombre;
    protected String tipo;
    protected float vida;
    protected int nivel;
    protected Botin recompensa;
    protected boolean esJefe;

    //Mis constructores
    public Monstruo(String nombre, String tipo, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.nivel = nivel;
        this.recompensa = recompensa;
        this.esJefe = esJefe;
    }

    //Mis setter
    public void setRecompensa(Botin recompensa) throws RecompensaIlegalException
    {
        if (this.esJefe && recompensa == null)
        {
            throw new RecompensaIlegalException("¡Error! Un Jefe no puede tener un botin nulo!", this.recompensa);
        }
            this.recompensa = recompensa;
    }
    public void setNivel(int nivel) throws AtributoInvalidoException
    {
        if (nivel <= 0)
        {
            throw new AtributoInvalidoException("El nivel no puede ser inferior o igual a cero!", this.nivel);
        }
            this.nivel = nivel;
    }
    public void setVida(float vida) throws AtributoInvalidoException
    {
        if (vida <= 0)
        {
            throw new AtributoInvalidoException("Vida no puede ser inferior a 1!", this.vida);
        }
            this.vida = vida;
    }

    //Mi toString
    @Override
    public String toString()
    {
        return "MONSTRUO: " + nombre +" [Nivel " + nivel + "]" +
                "\n > Status: " + (esJefe ? "JEFE" : "Normal") +
                "\n > Vida: " + vida +
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
    public void aumentoNivel() throws AtributoInvalidoException
    {
        setNivel(this.nivel + 1);
    }

    // Definir la estructura de un ataque
    public final void realizarAccionDeCombate()
    {
        System.out.println("--- Iniciando turno de " + nombre + " ---");
        prepararAtaque();

        float multi = calcularMultiplicadorDanio();
        System.out.println("Multiplicador aplicado: " + multi);

        finalizarAccion();
    }

    public abstract void prepararAtaque(); //abstracto
    public abstract void finalizarAccion(); //abstracto
}