Para mi elemento de desicion propia, esta vez decidi modificar el como los enemigos reciben daño
En los rpgs, los enemigos suelen tener un sistema de "piedra, papel y tijeras", donde dependiendo del elemento
en el que sean afines/debiles, recibiran un daño variable dependiendo del mismo. Por ejemplo, un enemigo hecho
de hielo, recibira muchisimo daño de un ataque de fuego, pero practicamente cero de un ataque de hielo.
Con el "realizarAccionDeCombate()", me aseguro de crear una secuencia. Primero preparo el ataque, luego ejecuto
las operaciones para determinar si es critico, si tiene efecto elemental, o si es un ataque fisico sin potenciadores,
por ultimo, llego a finalizar el ataque, por si necesito escribir codigo en esa parte como agregar robo de vida
o permitir al enemigo "escapar" de la batalla por ejemplo.