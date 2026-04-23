Para ejecutar el codigo, ejecutar Main.java

Para mi elemento de desicion propia nuevamente continue con mi proyecto de videojuego rpg.
En este escenario, separe a los tipos de monstruo en sus categorias.
El uso de herencia en mi proyecto es practicamente necesario si se trata con varios tipos de enemigos
que comparten ciertas cualidades.
Por ejemplo, tanto el lich como el zombie, al ser no muertos, ambos tienen la cualidad de recibir daño de
las curaciones. Para evitar el repetir codigo, la herencia permite meterlos a ambos dentro de una clase padre
que hereda las cualidades anti regenerativas por ser ambos no muertos.
Imagina que tuviera 100 tipos de enemigos no muertos; de no usar herencia, tendria que programar el comportamiento
exactamente igual a cada uno de ellos, lo cual es terriblemente ineficiente.

Honestamente la herencia no me causo problemas a la hora de crear la arquitectura de mi código. Mas que nada
por que el tema mismo se presta a estos escenarios. Ordenar a los diversos monstruos bajo cualidades comunes es
directamente el mejor metodo que se me puede ocurrir para evitar repetir código y hacerlo todo lo mas eficiente posible.

