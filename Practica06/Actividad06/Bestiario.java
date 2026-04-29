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

    //Interaccion de conversacion
    public void intentarDiplomacia()
    {
        System.out.println("\n--- Iniciando Fase de Diplomacia ---");
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

    //Fase de combate
    public void ejecutarFaseDeAccion()
    {
        System.out.println("\n--- Iniciando Fase de Acción de Combate ---");
        for (Monstruo m : listaMonstruos)
        {
            if (m instanceof Accion)
            {
                Accion a = (Accion) m;
                System.out.println(a.atacar());
            }
        }
    }
}