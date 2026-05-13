package Actividad10;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Archivador
{

    //Guardo en binario
    public static void guardarBestiario(Bestiario b, String ruta)
    {
        realizarBackup(ruta); //Backup automático antes de sobreescribir
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta)))
        {
            oos.writeObject(b.getLista());
            System.out.println("Datos guardados en binario correctamente.");
        } catch (IOException e)
        {
            b.registrarError(e);
        }
    }

    //Cargo desde Binario
    @SuppressWarnings("[unchecked]") //Ignoro la advertencia de archivo no sercionado para la lectura
    public static void cargarBestiario(Bestiario b, String ruta)
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta)))
        {
            ArrayList<Monstruo> listaCargada = (ArrayList<Monstruo>) ois.readObject();
            for (Monstruo m : listaCargada)
            {
                b.agregarMonstruo(m); // Esto llena también el HashMap y HashSet
            }
            System.out.println("Bestiario restaurado desde archivo binario.");
        } catch (IOException | ClassNotFoundException e)
        {
            b.registrarError(e);
        }
    }

    //Lectura de CSV
    public static void importarDesdeCSV(Bestiario b, String ruta)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta)))
        {
            String linea;
            while ((linea = br.readLine()) != null)
            {
                String[] d = linea.split(",");
                //Formato esperado: Tipo,Nombre,Vida,Nivel,ItemBotin,Oro,esJefe
                //Ejemplo de uso: zombie,Zombi_A,20,1,Pocion,10,false
                try
                {
                    Botin botin = new Botin(d[4], Integer.parseInt(d[5]));
                    Monstruo m = crearMonstruoPorTipo(d[0], d[1], Float.parseFloat(d[2]),
                            Integer.parseInt(d[3]), botin, Boolean.parseBoolean(d[6]));
                    if (m != null) b.agregarMonstruo(m);
                } catch (Exception e)
                {
                    System.out.println("Error en linea: " + linea);
                }
            }
        } catch (IOException e)
        {
            b.registrarError(e);
        }
    }

    //Exportacion para formato JSON
    public static void exportarAJSON(Bestiario b, String ruta)
    {
        StringBuilder json = new StringBuilder();
        json.append("[\n");
        for (int i = 0; i < b.getLista().size(); i++)
        {
            Monstruo m = b.getLista().get(i);
            json.append("  {\n")
                    .append("    \"nombre\": \"").append(m.getNombre()).append("\",\n")
                    .append("    \"nivel\": ").append(m.getVida()).append("\n")
                    .append("  }").append(i < b.getLista().size() - 1 ? "," : "").append("\n");
        }
        json.append("]");

        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta)))
        {
            pw.print(json.toString());
            System.out.println("Exportacion JSON completada.");
        } catch (IOException e)
        {
            b.registrarError(e);
        }
    }

    //Backup automatico con Timestamp añadido
    private static void realizarBackup(String rutaOriginal)
    {
        File original = new File(rutaOriginal);
        if (!original.exists()) return;

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File folder = new File("backups");
        if (!folder.exists()) folder.mkdir(); //Crea un directorio si no existe

        File backup = new File("backups/backup_" + timestamp + "_" + rutaOriginal);
        try
        {
            java.nio.file.Files.copy(original.toPath(), backup.toPath());
        } catch (IOException e)
        {
            System.out.println("No se pudo crear el backup...");
        }
    }

    //Auxiliar para el CSV
    private static Monstruo crearMonstruoPorTipo(String tipo, String nom, float v, int n, Botin b, boolean j) throws Exception
    {
        switch (tipo.toLowerCase())
        {
            case "zombie": return new zombie(nom, v, n, b, j);
            case "valstrax": return new valstrax(nom, v, n, b, j);
            case "lesserlich": return new lesserLich(nom, v, n, b, j);
            case "automata": return new automata(nom, v, n, b, j);
            case "chaosslime": return new chaosSlime(nom, v, n, b, j);
            default: return null;
        }
    }
}