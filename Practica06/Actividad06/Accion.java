package Actividad06;

public interface Accion
{
    default String atacar()
    {
        return " es incapaz de realizar sus ataque!";
    }
    default String bloquearAtaque()
    {
        return " no puede ejecutar el bloqueo de ataques!";
    }
    default String huidaTactica()
    {
        return " no puede huir!";
    }
}
