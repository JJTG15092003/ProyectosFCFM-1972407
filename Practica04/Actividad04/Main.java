package Actividad04;
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
        Monstruo m1 = new Monstruo("Lesser Lich", 150, 45, dropLich, true);
        Monstruo m2 = new Monstruo("Chaos Lord Slime",475000, 457, dropSlime, true);
        Monstruo m3 = new Monstruo("Zombie", 25, 5, dropComun, false);
        Monstruo m4 = new Monstruo("Automata de combate",45, 17, dropComun, false);
        Monstruo m5 = new Monstruo("Valstrax",75000, 40, dropElder, true);

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
    }
}