- Implementado el sistema de recompensas para el juego
- Se crea un cofre en el cual los monstruos van dropeando items al morir
- Los jugadores recogen dicho loot dentro del cofre

- Se divide el llenado del cofre por los monstruos y la recoleccion del loot por los jugadores con "agregarBotin" y
    "recogerBotin"
- En caso de que el cofre se llene, se activa el wait()
- Cada que se termina una accion, se notifica a todos los hilos con un notifyAll() para que se pueden re encender asi
    mismos