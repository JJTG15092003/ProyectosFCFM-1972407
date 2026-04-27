package Actividad05;

import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();
        //Contenedor de monstruos
        Bestiario miBestiario = new Bestiario();

        //Mis recompensas
        Botin dropLich = new Botin("Cetro de Hueso", 500);
        Botin dropSlime = new Botin("Núcleo de Caos", 10000);
        Botin dropComun = new Botin("Trapo sucio", 2);
        Botin dropElder = new Botin("Núcleo de Valstrax", 8000);

        //Necesitamos... MONSTRUOS
        lesserLich m1 = new lesserLich("Lesser lich", 150, 45, dropLich, true);
        zombie m2 = new zombie("Zombi común", 25, 5, dropComun, false);
        chaosSlime m3 = new chaosSlime("Chaos Demon Lord GodLike Slime", 75000000, 3000, dropSlime, true);
        valstrax m4 = new valstrax("Drágon anciano Valstrax", 75000, 75, dropElder, true);
        automata m5 = new automata("Sirvienta automata de porcelana", 150, 14, dropComun, false);

        miBestiario.agregarMonstruo(m1);
        miBestiario.agregarMonstruo(m2);
        miBestiario.agregarMonstruo(m3);
        miBestiario.agregarMonstruo(m4);
        miBestiario.agregarMonstruo(m5);

        for(Monstruo m : miBestiario.getLista())
        {
            // Usamos el Getter para consultar si es jefe
            if(m.isEsJefe())
            {
                System.out.println("¡CUIDADO! Apareció el jefe: " + m.getNombre());
            }
        }
        miBestiario.mostrarTodo();

        System.out.println("\n\n\n");
        //Generador de eventos aleatorios para probar que todo funcione

        System.out.println("=== INICIANDO SIMULACIÓN DE ENCUENTROS ===");

        for(Monstruo m : miBestiario.getLista())
        {
            System.out.println("\n--- Evento para: " + m.getNombre() + " ---");

            int evento = random.nextInt(3);

            switch(evento)
            {
                case 0:
                    System.out.println("[ACCIÓN: ATAQUE SORPRESA]");
                    m.recibirDanio(30.0f);
                    break;
                case 1:
                    System.out.println("[ACCIÓN: POCIÓN DE VIDA]");
                    m.recibirCura(15.0f);
                    break;
                case 2:
                    System.out.println("[ACCIÓN: ENTRENAMIENTO]");
                    m.aumentoNivel();
                    break;
            }
        }
    }
}