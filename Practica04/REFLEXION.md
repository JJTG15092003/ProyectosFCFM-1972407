1. ¿Qué ventaja concreta te dio la herencia en este ejercicio? ¿Qué código evitaste repetir?
   -
En este escenario, pude evitar repetir las cualidades que entre monstruos se comporatian por
proceder de la misma familia/tipo. Por ejemplo, Valstrax y el Chaos Slime, ambos siendo seres
organicos, comparten las cualidades de ser "neutrales", no reciben desventajas de la curacion ni del daño.
Asi que me evita tener que repetir tales condiciones en ellos mismos.
2. ¿Cuándo es apropiado usar =super()= y cuándo no es necesario?
    -
super() viene de "superior", el cual representa al padre de la clase que estoy manejando. Sirve para inicializar
datos que se encuentren en la clase padre. Por ende, no es necesario si estoy trabajando en mi clase hijo, y los
datos que requiero inicializar ya me los estan proporcionando ahi mismo.

3. ¿Qué pasa si una clase hija no sobrescribe un método de la clase padre?
    -
Simplemente se usara el de la clase padre. En mi código, reescribi el comportamiento de toString en cada monstruo,
pero aun asi mando a llamar el toString modificado en sus clases padre. De no haberlo hecho, se hubiera mantenido
el formato de las clases padres en su lugar.