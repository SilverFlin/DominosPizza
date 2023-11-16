# Ejercer Turno

## Clases

![Figure1](/docs/imgs/CD_ejercer_turno.png)

_Figure 1. Diagrama de Clase Ejercer Turno_ [^1]

| Componente        | Definicion                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| GameView          | <p>Es la interfaz de la Vista, del patrón MVP. <br> Su función es repsentar todos los cambios solicitados por el Presentador, de forma gráfica.</p><ul><li>`showInvalidError():void`: Despliega un mensaje de error.</li><li>`updateGame(GameViewModel model):void`: Actualiza todo el juego, obteniendo la información del Modelo el cual es proporcionado por el Presentador.</li></ul>                                                                                                                                                                                                                                                               |
| GameJFrame        | Implementación de la interfaz `GameView`, la cual lo hace mediante los JFrame de Java.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| GamePresenter     | Es la interfaz del Presentador, del patrón MVP. <br> Refleja los cambios de información en el Modelo y le dice a la Vista cómo comportarse.<ul><li>`putTileInBoard(DominoDTO domino): void`: Sirve para recibir el cambio de la vista. Aquí el Presentador actualiza al Modelo con la ficha regresada y vuelve a cargar la vista con los datos actualizados.<li>`updateGame(GameDTO game): void`: Sirve para recibir actualizaciones del juego, para así reflejarlas en el Modelo como en la Vista. <li>`takeFromPool(): void`: Es el método que la vista va a usar para avisar que el jugador está intentando agarrar del pool (pozo) de fichas. </ul> |
| GamePresenterImpl | Implementación de la interfaz `GamePresenter`.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| BasePresenter     | Consultar Event Processor [^2]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| EventProducer     | Consultar Event Processor[^2]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| GameModel         | Interfaz que contiene métodos para actualizar el Modelo, del patrón MVP.<br>El cómo se actuliza es  interactuando con las clases de Dominio, que se ve reflejado en el [Diagrama de Secuencia](#ds-ejercer-turno).<ul><li>`putTileInBoard(DominoDTO tile):void`: Intenta poner una ficha en el tablero.<li>`takeFromPool(PlayerDTO player):void`: Intenta agregar una ficha del pozo al jugador, si es que hay restantes.</li><li>`updateGame(GameDTO game):void`: Actualiza todo el modelo, este método se suele llamar cuando hay cambios nuevos de fuera i.e. del Servidor.</li></ul>                                                                |
| GameViewModel     | Es la versión segregada del Modelo, la cual se va a estar mandando a la Vista.<br>Contiene únicamente métodos para acceder a la información que la vista necesita para ser cargada o actualizada.<ul><li>`getBoard(): List<DominoDTO>`: Regresa el tren de fichas.<li>`getMyPlayer(): PlayerDTO`: Regresa el jugador actual.</li><li>`getRemainingTilesInPool(): int`: Regresa las fichas faltantes del pozo.</li><li>`getRoom(): List<OpponentDTO>`: Regresa los demás jugadores de la sala. </li></ul>                                                                                                                                                |
| GameModelImpl     | Esta clase implementa de `GameModel` y de `GameViewModel`. <br>Tiene una referencia de la clases de Dominio `DominoGame` con la información del juego actual y `Player`, que representa al jugador actual (Ver Clases de Domino[^3]).                                                                                                                                                                                                                                                                                                                                                                                                                   |

> Los DTOs se pueden consultar en [esta documentación](/docs/diagrams/dtos.md#clases).

## Secuencia

### DS Ejercer Turno

![Figure2](/docs/imgs/SD_ejercer_turno.png)

_Figure 2. Diagrama de Secuencia: Ejercer Turno_

Representa el flujo de información entre las clases de Dominio y las clases relacionadas al patrón MVP al momento de ejercer un turno.

### DS Actualizar Juego

![Figure3](/docs/imgs/SD_update_game.png)

_Figure 3. Diagrama de Secuencia: Actualizar Juego_

Representa el flujo de actualizar la vista con la información del Modelo, del patrón MVP.


[^1]: https://drive.google.com/file/d/1RLThj4k63heokaFVFKIsCeU1Zq4e663_/view?usp=drive_link
[^2]: /docs/diagrams/Event_Processor.md
[^3]: /docs/diagrams/DD_client.md