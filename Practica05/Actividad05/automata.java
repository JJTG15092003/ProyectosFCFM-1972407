package Actividad05;

public class automata extends automataRobot
{
    public automata(String nombre, float vida, int nivel, Botin recompensa, boolean esJefe)
    {
        super(nombre, vida, nivel, recompensa, esJefe);
    }

    @Override
    public void recibirDanio(float cantidad)
    {
        double probabilidad = Math.random();
        if(probabilidad > 0.5)
        {
            System.out.println(getNombre() + " no pudo soportar el ataque!");
            super.recibirDanio(cantidad * 1.3f);
            System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
        }
        else
        {
            System.out.println("¡SISTEMA DE DEFENSA ACTIVO! " + getNombre() + " bloqueó el ataque.");
        }
    }
    @Override
    public String toString()
    {
        return super.toString() + "\n > El cuerpo de " + getNombre() + " tambalea con cada intento de dar un paso...";
    }
    @Override
    public void aumentoNivel()
    {
        System.out.println(getNombre() + " sube de nivel! y se logra reconstruir!");
        super.aumentoNivel();
        this.vida += vida * 0.5f;
        System.out.println(getNombre() + " cuenta ahora con " + vida + " puntos de salud!");
    }
}