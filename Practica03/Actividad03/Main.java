package Actividad03;
public class Main
{
    public static void main(String[] args)
    {
        //Creación del contenedor de monstruos
        Bestiario miBestiario = new Bestiario();

        //Creación de monstruos de prueba
        Monstruo m1 = new Monstruo("Lesser Lich", "No-Muerto", 45, 1000, true);
        Monstruo m2 = new Monstruo("Chaos Lord Slime", "Organico", 4750, 75000, true);
        Monstruo m3 = new Monstruo("Zombie", "No-muerto", 5, 25, false);
        Monstruo m4 = new Monstruo("Automata de combate", "Constructo artificial", 17, 45, false);

        //Los agregamos al bestiario
        miBestiario.agregarMonstruo(m1);
        miBestiario.agregarMonstruo(m2);
        miBestiario.agregarMonstruo(m3);
        miBestiario.agregarMonstruo(m4);

        //Mostrando los datos de los monstruos
        miBestiario.mostrarTodo();

        //Prueba de metodos de instancia
        m1.recibirCura(500);
        m2.recibirDanio(400);
        m3.evolucion("Mutant Zombie");
        m4.aumentoNivel();
    }
}