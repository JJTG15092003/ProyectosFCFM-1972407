package Actividad07;

import Excepciones.AtributoInvalidoException;
import Excepciones.RecompensaIlegalException;

public class organico extends Monstruo implements EsqueletoComportamiento
{
    public organico(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe) throws AtributoInvalidoException, RecompensaIlegalException {
        super(nombre, "Orgánico", vida, nivel, recompensa, esJefe);
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