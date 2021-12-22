<h2>Pregunta 1 🐞 ¿Por que se define vehicles como un Set?</h2>
La razón principal por la que usamos la colección Set para guardar los vehículos a diferencia de las otras colecciones como Array o Map es que los Set no permiten almacenar elementos duplicados, dada la naturaleza del ejercicio, donde las placas de los vehículos no deben ser repetidas, de igual manera, otra característica particular de los Set es que los datos no están ordenados, algo ideal para el tipo de ejercicio, puesto que no nos interesa conocer el orden de las placas en ningún momento.

<h2>Pregunta 2 🦁 ¿Puede cambiar el tipo de vehículo en el tiempo?</h2>
Si, en caso de que a futuro se requiera cambiar los tipos de vehículos ya existentes o agregar un nuevo tipo.

<h2>Pregunta 3 🐣 ¿Debe definirse como variable o como constante en Vehicle?</h2>
Como variable, puesto que siguiendo los lineamientos de la pregunta anterior, si se desean agregar o editar los tipos de vehículos ya existentes se requiere que la propiedad Type sea una variable.

<h2>Pregunta 4 🪲 ¿Dónde deben agregarse las propiedades, en ParkingSpace, Vehicle o en ambos?</h2>
Dentro de ParkingSpace ya existe una instancia de Vehicle, por lo tanto estas propiedades deben agregarse en ParkingSpace, el cual tendrá la responsabilidad de tener el seguimiento de los vehículos

<h2>Pregunta 5 🐤 ¿Cómo indicamos que un tipo de datos puede adquirir esta característica en Kotlin?</h2>
Podemos indicar que una variable puede ser null ubicando un signo de interrogación al final de la declaración

