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
        //Generador de eventos aleatorios para probar que funcione

        System.out.println("=== SIMULACION DE COMBATE ===");

        for (Monstruo m : miBestiario.getLista())
        {
            m.realizarAccionDeCombate();

            System.out.println("Experiencia generada: " + m.generarExperienciaAlMorir());

            m.recibirDanio(10.0f);

            if (m instanceof valstrax)
            {
                valstrax v = (valstrax) m;
                v.recibirDanio(50.0f, "Agua"); // Sobrecarga 2 (Elemental)
                v.recibirDanio(100.0f, true);   // Sobrecarga 3 (Crítico)
                System.out.println("Estado del Dragón: " + v.toString());
            }
            else if (m instanceof zombie)
            {
                zombie z = (zombie) m;
                z.recibirDanio(20.0f, "Fuego"); // Sobrecarga de mi zombie
            }

            System.out.println("----------------------------------------------");
        }
    }
}