package Actividad06;

import java.util.ArrayList;

public class Bestiario
{
    private ArrayList<Monstruo> listaMonstruos;
    public Bestiario()
    {
        this.listaMonstruos = new ArrayList<>();
    }

    public ArrayList<Monstruo> getLista()
    {
        return listaMonstruos;
    }

    //Mis llamadas
    public void agregarMonstruo(Monstruo m)
    {
        listaMonstruos.add(m);
        System.out.println("Se ha registrado un nuevo monstruo!");
    }
    public void mostrarTodo()
    {
        System.out.println("=== Bestiario ===");
        for(Monstruo m : listaMonstruos)
        {
            System.out.println(m);
        }
    }

    //Conversador
    public void intentarDiplomacia()
    {
        System.out.println("\n--- Iniciando Diplomacia ---");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Conversador)
            {
                Conversador c = (Conversador) m;
                System.out.println(m.getNombre() + " responde: " + c.persuadir());
            } else
            {
                System.out.println(m.getNombre() + " no parece interesado en hablar.");
            }
        }
    }

    public void intentarDomesticacion()
    {
        System.out.println("\n--- Iniciando Domesticación");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Conversador)
            {
                Conversador c = (Conversador) m;
                System.out.println(m.getNombre() + c.domesticar());
            } else
            {
                System.out.println(m.getNombre() + " parece evasivo a tus intentos de domesticar.");
            }
        }
    }

    public void intentarIntimidar()
    {
        System.out.println("\n--- Iniciando Intimidación");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Conversador)
            {
                Conversador c = (Conversador) m;
                System.out.println(m.getNombre() + c.intimidar());
            } else
            {
                System.out.println(m.getNombre() + " no muestra signos de estar intimidado.");
            }
        }
    }

    //Accion
    public void ejecutarAtaque()
    {
        System.out.println("\n--- Atacando ---");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Accion)
            {
                Accion a = (Accion) m;
                System.out.println(a.atacar());
            }
        }
    }

    public void ejecutarBloqueo()
    {
        System.out.println("\n--- Bloqueando ataque ---");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Accion)
            {
                Accion a = (Accion) m;
                System.out.println(a.bloquearAtaque());
            }
        }
    }

    public void ejecutarHuida()
    {
        System.out.println("\n--- Huyendo ---");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Accion)
            {
                Accion a = (Accion) m;
                System.out.println(a.huidaTactica());
            }
        }
    }
}