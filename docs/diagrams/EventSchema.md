
# Event Schema

Event Schema es un proyecto que contiene las clases necesarias para la comunicación entre el servidor y el cliente. Estas clases representan los eventos que se pueden producir en el juego y la información que estos transmiten.

## Clases

![Figure1](/docs/imgs/CD_event_schema.png)

_Figure 1. Diagrama de Clase EventSchema_

| Componente                    | Definición                                                                                                                                                                                                                                                     |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Event                         | Clase abstracta, representa la estructura base de un Evento <ul><li>`type:EventType`: Representa el tipo de evento, sirve para diferenciarlos a la hora de recibirlos.</li><li>`payLoad:T`: Representa la información que el evento va a transmitir.</li></ul> |
| EventType                     | Enumerador con los tipos de Eventos.                                                                                                                                                                                                                           |
| ErrorSummary                  | Contiene un resumen de error.                                                                                                                                                                                                                                  |
| UpdateGameEvent\<DominoGame\> | Subclase del Event. <ul><li>`UpdateGameEvent(DominoGame dominoGame)`: Inicializa el payload y asigna el tipo de evento.</li></ul>                                                                                                                              |

