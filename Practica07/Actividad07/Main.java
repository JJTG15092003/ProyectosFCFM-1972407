package Actividad07;

public class Main
{
    public static void main(String[] args)
    {
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

        System.out.println("=== SIMULACION DE COMBATE ===");

        //Diplomacia
        miBestiario.intentarDiplomacia();
        //Intimidacion
        miBestiario.intentarIntimidar();
        //Accion
        miBestiario.ejecutarAtaque();

        //Demostracion
        System.out.println("\n--- Prueba de Métodos de Clase Base (Monstruo) ---");
        for (Monstruo m : miBestiario.getLista())
        {
            m.prepararAtaque(); // Método abstracto implementado
            m.recibirDanio(50); // Método concreto de la clase base
            System.out.println(m.getNombre() + " ahora tiene " + m.vida + " HP.");
        }
    }
}