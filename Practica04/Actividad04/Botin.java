package Actividad04;

public class Botin
{
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