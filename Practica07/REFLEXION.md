1. ¿Cuál es la diferencia entre una excepción chequeada (checked) y una no
   chequeada (unchecked)?
- Las revisadas o checked, estan obligadas por el lenguaje a siempre usar el throw, el try y el catch, mientras
    que las no revisadas o unchecked, son errores de logica a la hora de programar, y no son revisadas por que
    se espera que no sucedan si el programa esta correcto en primer lugar
2. ¿Por qué creaste una jerarquía de excepciones en lugar de usar
   =Exception= directamente?
- Asi me es mas facil encontrar los errores. Primero me llega el mensaje de "tienes un error", osease a
  BestiarioException, de ahi, ya dependiendo de como funcione la jerarquia, ira a las hijas para encontrar el error
    especifico, por ejemplo, si fuese por el nivel, de BestiarioExcepcion, pasaria a AtributoInvalidoException, y asi
    sucesivamente
3. ¿Qué ventaja tiene =try-with-resources= sobre un bloque =finally=
   tradicional?
- Me permite cerrar instantaneamente el archivo al terminar de usarlo. Esto por que al parecer, en versiones anteriores,
    se tenia que crear un bloque de finally con sus try y catchs, solo para cerrar el archivo, lo que lo hacia
    reduntante e ineficiente. Asi mismo, el try with resources, me permite cerrar el documento incluso si hay un
    cierre inesperado del programa, lo que evita perdida de datos y/o corrupcion