1. ¿Por qué marcamos atributos como =private=? ¿Qué riesgo evitamos?
    - Al marcarlos como privados, le quitamos el derecho a las clases ajenas como el main, a poder interactuar
    con los datos dentro de los mismos. Pero le seguimos permitiendo a su familia o a quien lo contenga, que
    modifique sus propios datos.
2. ¿Cuál es la diferencia entre =private=, =protected= y =public=? Ilustra
   con un ejemplo de tu código.
    para private, en mi clase de botin que fue donde lo use. Su funcion es poder ser modificado exclusivamente por
    su familia "Monstruo", la diferencia con private y public es que private solo permite que la clase a la que
    pertenece lo modifique. public es mas permisivo por que permite que cualquier otra clase que le haga referencia,
    pueda modificar su contenido.
3. ¿Qué validación incluiste en un setter? ¿Qué pasa si el valor recibido
   es inválido?
    - En uno de mis setters elegi una validacion comun, la cual es comprobar que nivel no sea inferior o igual a cero.
    En caso de que fuese cero o menor, imprimiria un error en pantalla.