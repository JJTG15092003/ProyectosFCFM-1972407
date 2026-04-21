package Actividad03;
import java.util.ArrayList;

public class Bestiario
{
    private ArrayList<Monstruo> listaMonstruos;
    public Bestiario()
    {
        this.listaMonstruos = new ArrayList<>();
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
}