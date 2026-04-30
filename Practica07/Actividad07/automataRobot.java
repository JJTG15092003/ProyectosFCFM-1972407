package Actividad07;

import Excepciones.AtributoInvalidoException;
import Excepciones.RecompensaIlegalException;

public class automataRobot extends Monstruo implements EsqueletoComportamiento
{
    public automataRobot(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe) throws AtributoInvalidoException, RecompensaIlegalException {
        super(nombre, "Constructo autónomo", vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirCura(float cantidad)
    {
        System.out.println("El cuerpo artificial de " + nombre + " es inmune a la curacion!");
    }

    @Override
    public void prepararAtaque() {

    }

    @Override
    public void finalizarAccion() {

    }

    @Override
    public float calcularMultiplicadorDanio() {
        return 0;
    }

    @Override
    public int generarExperienciaAlMorir() {
        return 0;
    }
}