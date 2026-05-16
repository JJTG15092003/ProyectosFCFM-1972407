¿Que es, y como puedo estructurar los "paquetes" para que el patron MVC?"
Repuesta de la IA:
- Me explico que "El patrón MVC separa la aplicación en tres capas para facilitar el mantenimiento", que son en modelo
    vista y controlador. Donde el modelo son clases con datos, la vista los archivos fxml que es lo que se vera, como
    el html de las paginas web, y el controlador, las clases que actuan de puente recibiendo datos y actualizando
    lo que se ve en la aplicacion

Me salio este error "NullPointerException" al cargar un fxml. ¿por que es?"
Respuesta de la IA:
- Me explico que es por que hice mal las referencias otra vez y por eso el programa no encuentra los archivos fisicos
    basicamente, escribi mal la direccion

"Recuerdame como era que evitaba que el hilo que tengo en segundo plano para las notificaciones me bloquee el
proyecto?"
Respuesta de la IA:
- Me explico que como son tareas pesadas, lo mejor es ejecutarlo en un hilo aparte y a usar el
  Platform.runLater(() -> { ... }), para enviar instrucciones al hilo principal sin perjudicar el rendimiento.

"Como le hacia para que se conecten los datos guardados de mis usuarios hacia la tabla de usuarios y se vea?"
Repuesta de la IA:
- Me explico el uso de ObservableList en la parte de controlador. Que es PersistenciaService quien lee los objetos,
    luego ahora si se cargan a el ObservableList, y se vincula al view en Tableview.

"Me volvio a salir el error javafx.fxml.LoadException: Invalid escape sequence Por que no deja de salirme?"
Respuesta de la IA:
- Me explico que es por que me equivoque en la escritura en los fxml. Despues de revisar dicho error, es por que
    use malamente el signo $ para los precios, y despues de que no dejara de salirme ese error, solo lo quite

"Para el punto 4, me pide Manual técnico (10–15 páginas) con diagramas UML Que es un diagrama UML?"
Respuesta de la IA:
- Me explico que vienen de las siglas Unified Modeling Language, que es el diagrama que tenia previamente hecho,
    solo falta que lo trabaje mas para cumplir con la practica