package Actividad03;
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

        //Necesitamos... MONSTRUOS
        Monstruo m1 = new Monstruo("Lesser Lich", "No-Muerto", 45, 1000, dropLich, true);
        Monstruo m2 = new Monstruo("Chaos Lord Slime", "Organico", 475, 7500, dropSlime, true);
        Monstruo m3 = new Monstruo("Zombie", "No-muerto", 5, 25, dropComun, false);
        Monstruo m4 = new Monstruo("Automata de combate", "Constructo artificial", 17, 45, dropComun, false);

        miBestiario.agregarMonstruo(m1);
        miBestiario.agregarMonstruo(m2);
        miBestiario.agregarMonstruo(m3);
        miBestiario.agregarMonstruo(m4);

        for(Monstruo m : miBestiario.getLista())
        {
            // Usamos el Getter para consultar si es jefe
            if(m.isEsJefe())
            {
                System.out.println("¡CUIDADO! Apareció el jefe: " + m.getNombre());
            }
        }

        miBestiario.mostrarTodo();
    }
}