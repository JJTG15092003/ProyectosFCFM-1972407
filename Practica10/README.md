Para ejecutar el codigo, ejecutar el Main.java

Para la actividad 10, y para el uso de hilos, decidi darle un boost al simulador de combates. Ahora se realiza
mediante hilos. El como funciona es que estan activos dos hilos, uno de ellos para el combate, que llena el cofre,
y otro para la recoleccion del mismo.
Mi codigo soluciona esta concurrencia, pues en un juego real, sobre todo en uno multijugador, dos jugadores pueden
interactuar con el mismo objeto al mismo tiempo o con desfases de milesimas de segundo. Es por esto que el uso de
hilos es lo mejor para recoleccion de items. En juegos donde una espada legendaria tiene el 1% de drop en un cofre,
sin hilos, dos jugadores podrian sacar la misma espada ya que el juego no tendria tiempo de realizar las operaciones
si no hay hilos. De esta manera, elimino el Race condition y la corrupcion de codigo