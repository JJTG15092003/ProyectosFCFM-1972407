package Actividad09;
import java.io.Serializable;



public class Botin implements Serializable
{
    private static final long serialVersionUID = 1L; //Mi firma
    private String nombre;
    private int valor;

    //Al tener "protected", sus datos solo podran ser accedidos atravez de su familia (herencias)
    protected int oro;
    protected String item;

    //Constructor

    public Botin(String item, int oro)
    {
        this.item = item;
        this.oro = oro;
    }

    //Metodo toString
    @Override
    public String toString()
    {
        return "Item: " + item + " | Oro: " + oro;
    }
}