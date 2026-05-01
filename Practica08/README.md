Mi elemento de desicion propia esta vez fue la busqueda/comprobacion para "vida minima para considerar peligroso"
El cual es una comprobacion que como su nombre sugiere, revisa si el enemigo ademas de ser jefe, cuenta con un
numero mayor de vida al de la vida para considerarse peligroso.
En un videojuego, sobre todo un rpg como el que estaba ideando, si que existen los bestiarios, o registros de monstruos.
En ellos, se clasifican a los monstruos en base a su rareza, dificultad, y niveles. La cosa es que, por ejemplo, si
varios enemigos de tipo jefe fueran agrupados en una sola lista, es pertinente acomodarlos desde el menos letal, al mas
letal. Para practicidad de esta practica, elegi centrarme en su vida, pero podria ser una conjuncion de todas, creando
por ejemplo, una media de letalidad.

==========================================================
- Mi analisis de tiempo de ejecucion
  -
==========================================================
- Busqueda por nombre
  -
    O(1) = Tiempo constante. Esto se debe a que el programa no busca mis datos uno por uno. Como usa un Hash, va
            directo a la informacion que requiere
- Insercion de monstruos
  - 
    O(1) = Unicamente agrega al final del Array o un HashMap el dato, asi que es instantaneo
- Busquedas compuestas
  -
  O(n) = Tiempo lineal. Usado en comprobaciones como la de enemigo poderoso. Donde esta obligado a revisar los n
            numeros de entradas que existen
- Ordenamiento
  - 
  O(log n) = El que usa Comparator. Utiliza algoritmos propios de optimizacion para ir acomodando los datos
- Eliminacion con iterador
  - 
  O(n) = Este recorre la lista en busca de lo que se le pide, asi que recorre los n numero de datos