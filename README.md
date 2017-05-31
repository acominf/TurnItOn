### Objetivo del juego
El objetivo del juego ayudar a desarrollar la logica de programación del jugador, por medio de niveles en los que se tiene que llegar a la meta, diseñando algoritmos.

### Descripción del juego
En los niveles, tienes que formar un diagrama de bloques, con los bloques ya definidos, con mecánicas similares a las de Scratch. Como jugador, cuentas con una serie de pestañas para cada nivel, algunas condicionales (como el while), otras de condición, y otras de acción También hay un panel que ejecuta tus acciones según lo necesites.

### Clases principales y sus características
1. Hayley
* Puede explorar cada nivel, moviéndose deacuerdo a las pestañas
* Se mueve a una velocidad normal, ya sea a la derecha, a la izquierda, hacia arriba o hacia abajo
* Es el protagonista del juego

![Imagen de Hayley](https://raw.githubusercontent.com/acominf/TurnItOn/master/Hayley.png)


2. Pestaña condicional
* Tiene un campo para ponerle una condicion, y un campo para ponerle una accion
* Se puede mover arrastrándola con el mouse
* Repite la actividad que represente, mientras se cumpla la condicion

![Imagen de la condicional](https://raw.githubusercontent.com/acominf/TurnItOn/master/whi.png)


3. Pestaña condicion
* Representa una condicion dentro del juego, por ejemplo, si el camino esta despejado
* Comprueba y actualiza constantemente el valor booleano de la condicion que representa
* Se comunica con la pestaña condicional, diciéndole si la condición se está cumpliendo

![Imagen de la condicion](https://raw.githubusercontent.com/acominf/TurnItOn/master/Pared%20al%20frente.png)


4. Pestaña acción
* Representa una acción específica sobre el protagonista (Hayley)
* Le dice a la pestaña condicional qué accion debe repetir
* Causa principalmente movimiento hacia alguna dirección

![Imagen de la accion](https://raw.githubusercontent.com/acominf/TurnItOn/master/correr%20arriba.png)


5. Pared
* Le impide al protagonista (Hayley) seguir caminando, ya que no se pueden atravesar
* Algunas de ellas, (como la meta y las opciones del menú), pueden desencadenar reacciones en el juego
* Juntas, formuan un laberinto para hacer cada nivel

![Imagen de una pared](https://raw.githubusercontent.com/acominf/TurnItOn/master/Par.png)


6. Panel
* Tiene cuatro campos, y en cada uno se puede poner una pestaña condicional
* Cuenta con botones de pausa y de reseteo, para ayudar al jugador a controlar el curso del juego
* Ejecuta las condicionales que tenga en sí, una por una y en orden

![Imagen del panel](https://raw.githubusercontent.com/acominf/TurnItOn/master/pan.png)



### Diagrama de clases
![Diagrama de clases](https://raw.githubusercontent.com/acominf/TurnItOn/master/Turn%20it%20on!.png)

### Gameplay del juego
<iframe width="560" height="315" src="https://www.youtube.com/embed/u1ji_zKLXVw" frameborder="0" allowfullscreen></iframe>

### Autores
Los autores del proyecto son:
- José Pablo García Limón (@YoSiSoyBatman)
- Daniel Omar Torres Carbajal(@YouKiddingD)

### Materia
- Programación Orientada a Objetos

### Semestre
- 2016-2017/II

### Markdown
El contenido de esta página está escrito en un lenguaje de marcado sencillo llamado *Markdown*. Para más detalles consulta la página de [Markdown para GitHub](https://guides.github.com/features/mastering-markdown/).

### Temas de Jekyll
El estilo y presentación de esta página utiliza el tema de Jekyll seleccionado en la configuración del repositorio. El nombre de este tema está almacenado en el archivo de configuración `_config.yml`. Para más información acerca de los temas de Jekyll soportados por GitHub [haz click en este enlace](https://pages.github.com/themes/).
