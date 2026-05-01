1. ¿Por qué usaste cada estructura de colección para cada tipo de dato?
   ¿Qué pasaría si usaras =ArrayList= para todo?
- Podria usar sin problemas el ArrayList, pero este solo guarda los datos conforme vallan entrando. Entonces
    me imposibilita mucho el acomodarlos y ordenarlos en base a un dato o datos especificos.
    Es por eso que use las demas colecciones, como el HashMap para elegir un dato especifico, o el base a nombre para
    que queden en orden alfabetico. Asi me da muchas mas posibilidades
2. ¿Qué diferencia hay entre =Comparable= y =Comparator=? ¿Cuándo usarías
   cada uno?
- Comparable se usa para marcar como quiero ordenar las cosas. Por ejemplo, en mi bestiario lo use para ordenar mis
    monstruos por niveles. Mientras que Comparator es una clase externa, que funciona para crear ordenes alternativos
    como buscar por el nombre desde mi main
3. Explica con tus palabras qué hace una operación Stream. ¿Por qué es más
   legible que un bucle =for=?
- El Stream hace que las instrucciones recorran una "cinta" de procesos, y es muchisimo mas eficiente que el for, pues
    te ahorras el tener que crear el contador y en mi caso, ir agregando los monstruos uno por uno. A este solo le das
    la orden de a donde quieres llegar, y se encargara de ello paso a paso