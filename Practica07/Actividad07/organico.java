package Actividad07;

import ExcepcionesAct8.AtributoInvalidoException;
import ExcepcionesAct8.RecompensaIlegalException;

public class organico extends Monstruo implements EsqueletoComportamiento
{
    public organico(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe) throws AtributoInvalidoException, RecompensaIlegalException, ExcepcionesAct7.RecompensaIlegalException {
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