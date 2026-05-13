1. ¿Qué es una race condition? Describe un escenario concreto de tu código
   donde podría ocurrir.
- Sucede cuando dos hilos que se ejecutan en paralelo intentar modificar una variable o algo dentro del codigo
    y estos al ser independientes entre ellos, pueden solaparse o generar operaciones erroneas. En mi codigo,
    los jugadores pueden tomar objetos del cofre, la cosa es que de suceder este "race condition", dos jugadores
    podrian tomar el mismo unico objeto dentro del cofre, lo cual en un rpg multijugador, podria considerarse trampa
    o "exploit"
2. ¿Por qué =synchronized= resuelve el problema? ¿Qué desventaja de
   rendimiento tiene?
- synchronized crea un candado para que solo un hilo pueda ejecutarse a la vez, y el resto se ponen en modo de espera.
    la desventaja es que bien se podrian tener un monton de hilos en espera, lo que causaria un bajon de rendimiento
    enorme. Por ejemplo, si hubieran cientos de jugadores como en un MMO, tratando de recolectar el loot de un mismo
    cofre, la espera de hilos seria enorme, y colapsaria el juego.
3. ¿Qué diferencia hay entre =Thread.sleep()= y =Object.wait()=? ¿Cuándo
   usarías cada uno?
- sleep le pone pausa al hilo en ejecucion, pero no suelta el candado, por lo que aunque este en pause, el resto de
    hilos deben de seguir esperandose, mientras que wait, provoca que se deje de ejecutar, y que el siguiente hilo
    en la lista, empiece a trabajarse. El wait lo uso cuando quiero que mi personaje se espere de seguir tomando
    items del cofre por que justo un monstruo acaba de morir y esta por dejar mas items en el cofre, el sleep cuando
    quiero ejecutar codigo fuera de los hilos para operaciones con el personaje en cuestion, como cambiar su vida o
    defensa