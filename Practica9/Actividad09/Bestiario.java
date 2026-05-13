package Actividad09;

import ExcepcionesAct8.AtributoInvalidoException;
import ExcepcionesAct8.BestiarioException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Bestiario
{
    private ArrayList<Monstruo> listaMonstruos;
    private HashMap<String, Monstruo> mapaPorNombre;
    private HashSet<String> tiposDescubiertos;
    private LinkedList<String> historialCombate;

    public Bestiario()
    {
        this.listaMonstruos = new ArrayList<>();
        this.mapaPorNombre = new HashMap<>();
        this.tiposDescubiertos = new HashSet<>();
        this.historialCombate = new LinkedList<>();
    }

    public ArrayList<Monstruo> getLista()
    {
        return listaMonstruos;
    }

    //Mis llamadas
    public void agregarMonstruo(Monstruo m)
    {
        listaMonstruos.add(m);
        mapaPorNombre.put(m.getNombre(), m);
        tiposDescubiertos.add(m.getTipo());
        historialCombate.addFirst("Registrado: " + m.getNombre());
    }

    public List<Monstruo> filtrarJefesPeligrosos(float vidaMinima)
    {
        return listaMonstruos.stream()
                .filter(m -> m.isEsJefe() && m.getVida() > vidaMinima)
                .collect(Collectors.toList());
    }

    public void subirNivelMonstruo(String nombre) throws AtributoInvalidoException
    {
        Monstruo m = mapaPorNombre.get(nombre);
        if (m != null)
        {
            m.aumentoNivel();
            historialCombate.addFirst("Nivel subido: " + nombre);
        }
    }

    public void eliminarMonstruosDebiles(float vidaMinima)
    {
        Iterator<Monstruo> it = listaMonstruos.iterator();
        while (it.hasNext()) {
            Monstruo m = it.next();
            if (m.getVida() < vidaMinima)
            {
                mapaPorNombre.remove(m.getNombre());
                it.remove();
            }
        }
    }

    public void mostrarTodo()
    {
        System.out.println("=== Bestiario ===");
        for(Monstruo m : listaMonstruos)
        {
            System.out.println(m);
        }
    }

    //guardar los errores
    public void registrarError(Exception e)
    {
        // try-with-resources asegura que el FileWriter se cierre solo
        // wow no sabia ^
        try (FileWriter fw = new FileWriter("errores_bestiario.log", true);
             PrintWriter pw = new PrintWriter(fw))
        {

            pw.println("=== ERROR DETECTADO ===");
            pw.println("Fecha: " + java.time.LocalDateTime.now());
            pw.println("Mensaje: " + e.getMessage());

            if (e instanceof BestiarioException)
            {
                pw.println("Timestamp original: " + ((BestiarioException) e).getTimestamp());
            }

            pw.println("-----------------------\n");

        } catch (IOException ioException)
        {
            System.out.println("Error fatal: No se pudo escribir en el log.");
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
                System.out.println(c.persuadir());
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
                System.out.println(c.domesticar());
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
                System.out.println(c.intimidar());
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

    //Mi HashMap para buscar al Monstruo en funcion de su nombre (Esto sera mi key)
    public HashMap<String, Monstruo> getMapaPorNombre()
    {
        return mapaPorNombre;
    }

    //Mi historial de los eventos
    public void mostrarHistorial()
    {
        System.out.println("=== Historial de Eventos Recientes ===");
        for (String evento : historialCombate)
        {
            System.out.println("- " + evento);
        }
    }
}