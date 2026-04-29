1. ¿Cuándo preferirías una clase abstracta sobre una interfaz? ¿Y al revés?
    No diria que sean excluyentes, mas bien son complementarias. Si no uso una interfaz, es por que el codigo
    ya es muy compacto o no tengo tantos metodos repetitivos. En cambio, si pienso usar metodos en varias clases
    y estos son los mismos para todos, pues si que me conviene tenerlos todos ordenados en una interfaz
2. ¿Una clase puede implementar varias interfaces? ¿Por qué Java permite
   eso pero no herencia múltiple de clases?
    La clase si puede usar varias interfaces, en esta misma practica use 3 interfaces entre los 5 monstruos.
    Ahora bien, el por que no usar multiples clases, es sencillo, es por que al usar clases multiples, puedo por error
    declarar dos metodos iguales, lo que provocaria que la clase hija que las esta llamando, no sepa a cual de las dos
    hacerle caso.
3. Si agregas un método nuevo a una de tus interfaces, ¿qué clases se ven
   afectadas? ¿Cómo lo resolverías con un método =default=?
    Este error lo tuve de primera mano. Resulta que si agrego un metodo nuevo en la interfaz, automaticamente cualquier
    clase que este usando dicha interfaz empezara a dar error. Este error pide que se agregue dicho metodo a la clase.
    Aunque hay escenarios en donde ese metodo justamente no lo necesitas en la clase, por lo que entra el default.
    Se pone automaticamente en cualquier clase que no este usando un Override para este metodo. Y sirve para dejar
    preestablecido un comportamiento para el metodo en caso de no usarse.
    En mi practica, no queria que ciertos monstruos usaran todos los metodos, por lo que les agregaba el default
    en las interfaces, y asi podia omitirlos.