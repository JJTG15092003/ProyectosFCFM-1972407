package Actividad10;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Bestiario miBestiario = new Bestiario();
        Scanner leer = new Scanner(System.in);
        int opcion = -1;

        Comparator<Monstruo> porVida = (m1, m2) -> Float.compare(m2.getVida(), m1.getVida());
        Comparator<Monstruo> porNombre = (m1, m2) -> m1.getNombre().compareTo(m2.getNombre());

        //Necesitamos... MONSTRUOS
        cargarDatosPrueba(miBestiario);

        System.out.println("--- BIENVENIDO AL SISTEMA DEL BESTIARIO ---");

        while (opcion != 0) {
            System.out.println("\n========= MENÚ DE GESTIÓN =========");
            System.out.println("1. Ver Bestiario (Orden Natural por Nivel)");
            System.out.println("2. Ordenar por Vida (Descendente)");
            System.out.println("3. Ordenar por Nombre (Alfabético)");
            System.out.println("4. Buscar Monstruo por Nombre (HashMap)");
            System.out.println("5. Filtrar Jefes Peligrosos (Streams)");
            System.out.println("6. Eliminar Monstruos Débiles (Iterator)");
            System.out.println("7. Mostrar el historial");
            System.out.println("8. Guardar Bestiario (Archivo Binario)");
            System.out.println("9. Cargar Bestiario (Archivo Binario)");
            System.out.println("10. Importar Monstruos (Desde CSV)");
            System.out.println("11. Exportar Reporte (Formato JSON)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try
            {
                opcion = Integer.parseInt(leer.nextLine());

                switch (opcion)
                {
                    case 1:
                        //Comparacion convencional (la del mostrar todo)
                        Collections.sort(miBestiario.getLista());
                        miBestiario.mostrarTodo();
                        break;
                    case 2:
                        //Comparacion en base a la vida del monstruo
                        miBestiario.getLista().sort(porVida);
                        miBestiario.mostrarTodo();
                        break;
                    case 3:
                        //Comparacion en base al nombre del monstruo
                        miBestiario.getLista().sort(porNombre);
                        miBestiario.mostrarTodo();
                        break;
                    case 4:
                        System.out.print("Ingresa el nombre exacto del monstruo: ");
                        String nombreBuscar = leer.nextLine();
                        Monstruo encontrado = miBestiario.getMapaPorNombre().get(nombreBuscar);
                        if (encontrado != null)
                        {
                            System.out.println("--- Monstruo Encontrado (Búsqueda O(1)) ---");
                            System.out.println(encontrado);
                        } else
                        {
                            System.out.println("No se encontró ningún monstruo con ese nombre.");
                        }
                        break;
                    case 5:
                        //Mi filtro compuesto
                        System.out.print("Vida mínima para considerar peligroso: ");
                        float vMin = Float.parseFloat(leer.nextLine());
                        List<Monstruo> peligrosos = miBestiario.filtrarJefesPeligrosos(vMin);
                        peligrosos.forEach(System.out::println);
                        break;
                    case 6:
                        System.out.print("Vida mínima para sobrevivir: ");
                        float vCorte = Float.parseFloat(leer.nextLine());
                        miBestiario.eliminarMonstruosDebiles(vCorte);
                        System.out.println("Limpieza completada.");
                        break;
                    case 7:
                        miBestiario.mostrarHistorial();
                        break;
                    case 8:
                        System.out.println("Guardando Bestiario...");
                        Archivador.guardarBestiario(miBestiario, "bestiario.dat");
                        break;

                    case 9:
                        System.out.println("Cargando desde archivo binario...");
                        Archivador.cargarBestiario(miBestiario, "bestiario.dat");
                        break;

                    case 10:
                        System.out.println("Importando datos desde CSV...");
                        Archivador.importarDesdeCSV(miBestiario, "monstruos.csv");
                        break;

                    case 11:
                        System.out.println("Exportando a formato JSON...");
                        Archivador.exportarAJSON(miBestiario, "reporte.json");
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Error en la entrada de datos: " + e.getMessage());
            }
        }
    }

    //Creacion de monstruos
    private static void cargarDatosPrueba(Bestiario b)
    {
        try
        {
            Botin comun = new Botin("Pocion", 10);
            Botin raro = new Botin("Gema de Alma", 500);
            Botin legendario = new Botin("Fragmento Estelar", 2000);

            b.agregarMonstruo(new zombie("Zombi A", 20, 1, comun, false));
            b.agregarMonstruo(new zombie("Zombi B", 25, 2, comun, false));
            b.agregarMonstruo(new lesserLich("Lesser-Lich", 100, 10, raro, true));
            b.agregarMonstruo(new automata("Maid Automata", 150, 5, comun, false));
            b.agregarMonstruo(new valstrax("Valstrax", 5000, 50, legendario, true));
            b.agregarMonstruo(new chaosSlime("Slime Rojo", 30, 3, comun, false));
            b.agregarMonstruo(new chaosSlime("Slime Azul", 35, 4, comun, false));
            b.agregarMonstruo(new zombie("SkinWalker", 40, 6, comun, false));
            b.agregarMonstruo(new lesserLich("Arch-Lich", 300, 20, raro, true));
            b.agregarMonstruo(new automata("Automata de combate", 200, 15, raro, false));
            b.agregarMonstruo(new chaosSlime("ChaosLordSlime", 1000000, 750, legendario, true));
            b.agregarMonstruo(new valstrax("Cria de Dragon", 800, 12, raro, false));
            b.agregarMonstruo(new zombie("Héroe roto", 50, 8, comun, false));
            b.agregarMonstruo(new automata("Centinela", 400, 18, raro, false));
            b.agregarMonstruo(new lesserLich("Constructo de sombras", 120, 9, comun, false));
        }
        catch (Exception e)
        {
            System.out.println("Error cargando datos!!: " + e.getMessage());
        }
    }
}