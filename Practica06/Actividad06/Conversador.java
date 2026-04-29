package Actividad06;

public interface Conversador
{
    default String persuadir()
    {
        return " no puede ser persuadido";
    }
    default String intimidar()
    {
        return " no puede ser intimidado";
    }
    default String domesticar()
    {
        return " no puede ser domesticado";
    }
}