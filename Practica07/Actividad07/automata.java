package Actividad07;

import Excepciones.AtributoInvalidoException;
import Excepciones.RecompensaIlegalException;

public class automata extends automataRobot implements EsqueletoComportamiento, Accion, Conversador
{
    public automata(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
            throws AtributoInvalidoException, RecompensaIlegalException
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        double probabilidad = Math.random();
        if(probabilidad > 0.5)
        {
            System.out.println(getNombre() + " no pudo soportar el ataque!");
            super.recibirDanio(cantidad * 1.3f);
            System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
        }
        else
        {
            System.out.println("¡SISTEMA DE DEFENSA ACTIVO! " + getNombre() + " bloqueó el ataque.");
        }
    }

    // Sobrecarga 2: Daño Elemental
    public void recibirDanio(float cantidad, String tipoElemental)
    {
        if (tipoElemental.equalsIgnoreCase("Electrico"))
        {
            System.out.println("¡El automata sufre un cortocircuito!");
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
            System.out.println("¡HAZ IMPACTADO EN LA ZONA DEBIL DE SU CARCAZA!");
            this.recibirDanio(cantidad * 2.0f);
        } else
        {
            this.recibirDanio(cantidad);
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n > El cuerpo de " + getNombre() + " tambalea con cada intento de dar un paso...";
    }
    @Override
    public void aumentoNivel() throws AtributoInvalidoException
    {
        System.out.println(getNombre() + " sube de nivel! y se logra reconstruir!");
        super.aumentoNivel();
        this.vida += vida * 0.5f;
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }

    //Comportamientos de conversacion
    @Override
    public String persuadir()
    {
        return getNombre() + " El constructo realiza un gesto teatral de apariencia apasible";
    }

    @Override
    public String intimidar()
    {
        return getNombre() + " Da un paso hacia atras con un gesto de miedo.\nSus brazos mecanicos se tensan...";
    }

    @Override
    public String domesticar()
    {
        return getNombre() + " Luce mucho mas apacible, su pose de combate flaquea. Quizas tengas una oportunidad!";
    }

    //Acciones de combate
    @Override
    public String atacar()
    {
        return getNombre() + " se lanza contra el jugador balanceando su cuchillo de carnicero gigante!";
    }

    @Override
    public String bloquearAtaque()
    {
        return getNombre() + " utiliza su cuchillo gigante para bloquear el ataque!";
    }

    @Override
    public String huidaTactica()
    {
        return getNombre() + " sale corriendo del lugar!";
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