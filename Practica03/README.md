Para ejecutar el programa, ejecutar "Main.java"

Para mi seleccion de reglas de validacion, trabaje en tres setters, recompensa, vida y nivel.
- Para recompensa, contemple que, un jefe tiene que tener por lo menos un tipo de recompensa/loot,
ya que dentro del juego, si no tiene un loot, se sentira como un enemigo inacabado, asi que inclusive
si se trata de un placeholder, tiene que tener algo que darle al jugador.
- Para la vida y nivel, en ambas condiciones contemplé lo mismo, un enemigo no puede aparecer con vida en cero
o negativos, pues están en cero, representa que ha sido derrotado y desapareceria en el instante en que es
instanciado. Por el otro lado, el nivel, como minimo tiene que ser 1, pues en el desarrollo de videojuegos,
las estadisticas son exponenciales basándonos en el nivel, por ejemplo, vida += nivel * 0.5
Permitir un nivel 0, implicaria que las estadisticas de los enemigos podrian recibir multiplos de cero, dando
estadisticas imposibles.