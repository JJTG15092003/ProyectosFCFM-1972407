import java.util.ArrayList;

public class Bestiario
{
    private ArrayList<Monstruo> listaMonstruos;
    public Bestiario()
    {
        this.listaMonstruos = new ArrayList<>();
    }
    public void agregarMonstruo(Monstruo m)
    {
        listaMonstruos.add(m);
        System.out.println("Se ha registrado un nuevo mosntruo!");
    }
    public void mostrarTodo()
    {
        System.out.println("=== BESTIARIO ===");
        for(Monstruo m : listaMonstruos)
        {
            m.mostrarInfo();
        }
    }

    public Monstruo buscarNombre(String nombreABuscar)
    {
        for(Monstruo m : listaMonstruos)
        {
            if(m.getNombre().equalsIgnoreCase(nombreABuscar))
            {
                return m;
            }
        }
        System.out.println(nombreABuscar + " No encontrado!");
        System.out.println("¿Qué estas buscando?");
        return null;
    }
}