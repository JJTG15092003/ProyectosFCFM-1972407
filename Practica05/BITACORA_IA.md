"Entonces lo primero que debo hacer es crear la clase Interactuable.java, esto es la "interfaz", dentro van las cosas que todos los monstruos pueden hacer. Esas funciones donde estan declaradas? como la de calcularMultiplicadorDanio()"
Respuesta de la IA:
- Me explico que las funciones interactuables no necesitan estar directamente declaradas, pues solo son "firmas" del metodo que se llamara
  como una "lista de promesas"

"Ok, ya tengo lo que me encargaron del punto 1. Queria saber si esta condicion la hice bien. Si la vida es superior al 50%, su daño es superior a que si fuera menor del 50%"
Respuesta de la IA:
- Me explico que tenia mal la condicion para obtener el 50% de la vida del chaosSlime, y que necesitaba usar una variable extra llamada vidamax para
  guardar la vida maxima del monstruo y sobre el, realizar el procedimiento

"Por otro lado. ¿como saber la interfaz que operacion debe de hacer. Por que por lo que veo, el return solo regresa un valor, y en la clase interfaz solo tengo los metodos llamandose, pero no se declara su comportamiento en ningun lado. Estoy olvidando algo?"
Respuesta de la IA:
- Cuando en tu Main llamas a monstruo.calcularMultiplicadorDanio(), Java revisa de qué tipo es el objeto en tiempo de ejecución. Si el objeto es un valstrax, ejecutará el código que escribiste en esa clase. Si es un zombie, ejecutará el código de la clase zombie. Esto es precisamente el Polimorfismo

"Y por que no podria instanciar una clase abstarcta en java de forma instantanea?"
Respuesta de la IA:
- Me explica que representan un concepto, no cosas tangibles, por lo que no se pueden llamar sin antes ponerlas en
    contexto. Por ejemplo, mi prepararAtaque(), nisiquiera tiene escrito el comportamiento, y esto es por que se espera
    que mi main y monstruo les de comportamiento para saber que tiene que hacer, en ese caso, iniciar la linea de
    codigo debajo de la calcularMultiplicadorDanio()