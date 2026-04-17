import java.util.Scanner;

public class ConversorDeTemperaturas
{
    static void main(String[] args)
    {
        Scanner lector = new Scanner(System.in);
        System.out.println("Programa para convertir grados celcius en fahrenheit");
        System.out.println("Introduce los grados celcius: ");
        double celsius = lector.nextDouble();

        double fahrenheit = (celsius * 9 / 5 ) + 32;

        System.out.println(celsius + " grados celcius equivalen a " + fahrenheit + " grados fahrenheit");

        lector.close();
    }
}