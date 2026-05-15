1. ¿Qué es el hilo de la UI (JavaFX Application Thread) y por qué no debes
   hacer operaciones pesadas en él?
- Este hilo, permite el input del mouse y teclado en la aplicacion y renderizar la pantalla. El por que no
    sobrecargarlo es por que eventualmente de tantas tareas, se realentiza y se puede llegar a congelar la aplicacion

2. ¿Qué es un =EventHandler=? ¿Cómo conecta la acción del usuario con la lógica de tu programa?
- Es una interface que manda un mensaje cada que el usuario interactuca con el codigo como por ejemplo presionar un
    boton

3. ¿Qué diferencia hay entre un =Stage=, una =Scene= y un =Node= en JavaFX?
- El stage es la ventana principal del sistema operativo, mientras que scene es lo que tiene dentro. Los nodos son
    todos los elementos interactivos como cuadros de texto, botones y tablas