# Iniciar Partida

## Clases

![Figure1](/docs/imgs/CD_iniciar_partida.png)

_Figure 1. Diagrama de Clase de Iniciar Partida_

El diagrama editable se encuentra en [este link](https://drive.google.com/file/d/1IWsLf2v58zQCyrJ0lhxCQMWl16wX-IUh/view?usp=drive_link).

| Componente        | Definicion                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| ----------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| MainMenuView      | <p>Es la interfaz de la Vista, del patrón MVP. <br>Su función es la de mostrar los paneles necesarios entre la pantalla de carga hasta antes de llegar al juego.</p><ul><li>`goToAvatarPanel():void`: Representa la interacción del usuario, de ir a la pantalla de avatares.</li><li>`close():void`: Termina la instancia de esta vista,  para ser cambiada a otra vista.</li><li>`updateWaitingRoom(MainMenuViewModel viewModel): void`: Es llamada al recibir cambios del presentador para actualizar la sala de espera.</li><li>`showLobbyPanel(MainMenuViewModel viewModel):void`: Cambia al panel de Lobby.</li><li>`showInvalidNameError():void`: Muestra al usuario un error de nombre invalido, debido a la existencia de ese nombre en la sala de espera.</li><li>`goToWaitingRoom():void`: Representa la interacción de usuario, de ir a la sala de espera.</li><li>`showAvatarPanel():void`: Cambia al panel de selección de Avatar.</li></ul> |
| MainMenuPresenter | Representa al Presentador, del patrón MVP. <br> Es el encargado de decirle a la Vista qué cargar y de actualizar a su Modelo. <ul><li>`goToAvatarPanel():void`: Es el método por el cual la vista le avisa al presentador de que el usuario quiere cambiar al panel Avatar.</li><li>`goToWaitingRoom():void`: Es el método por el cual la vista le avisa al presentador de que el usuario quiere cambiar al panel de la sala de espera.</li><li>`showInvalidNameError():void`: Es el método que usa el Router para avisarle al presentador de que no se puede usar el nombre proporcionado.</li><li>`updateWaitingRoom():void`: Es el método por el cual el Router le manda nueva información al presentador. </li></ul>                                                                                                                                                                                                                                   |
| MainMenuModel     | Representa al Modelo, del patrón MVP, que contiene métodos para actualizar las clases de Dominio.  <ul><li>`configurateWaitingRoom(PlayerDTO myPlayer, WaitingRoomDTO waitingRoom):void`: Crea el seguimiento a las instancias del jugador actual y de la sala de espera.</li><li>`setPlayerAdmin():List<PlayerDTO>` Asigna al jugador como admin, en caso de que lo sea, y regresa la lista de jugadores actualizada.</li><li>`setWaitingRoom():void`: Actualiza la sala de espera, por lo general guando hay cambios nuevos de fuera.</li><li>`setMyPlayer(PlayerDTO player): void`: Inicializa al jugador de la sesión actual.</li><li>`isReady():boolean`: En base a la lógica de negocio en el dominio, regresar true si el estado de actual de la sala de espera representa que el juego esta listo para iniciar.</li></ul>                                                                                                                          |
| MainMenuViewModel | Es la versión segregada del modelo, conteniendo únicamente métodos para acceder a la información de este, necesarios para ser cargados en la vista. <ul><li>`getAvatars():List<AvatarDTO>`: Regresa una lista con la información necesaria para cargar Avatares.</li><li>`getMyPlayer():PlayerDTO`: Regresa la información del jugador actual.</li><li>`getWaitingRoom():WaitingRoomDTO`: Regresa información de la sala de espera.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| MainMenuModelImpl | Es la clase que implementa a `MainMenuModel` y `MainMenuViewModel`.<br>Tiene una referencia de la clases de Dominio `DominoGame` con la información del juego actual y `Player`, que representa al jugador actual (Ver [Clases de Domino](/docs/diagrams/DD_client.md))                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |

> Los DTOs se pueden consultar en [esta documentación](/docs/diagrams/dtos.md#clases).

## Robustez

### Iniciar Partida

![Figure2](/docs/imgs/robustness_iniciar_partida.png)

_Figure 2. Diagrama de Robustez: Iniciar Partida_

## Secuencia

### DS Iniciar Partida

![Figure3](/docs/imgs/SD_iniciar_partida.png)

_Figure 3. Diagrama de Secuencia: Ejercer Turno_

Representa el flujo de información entre las clases de Dominio y las clases relacionadas al patrón MVP al momento de iniciar partida.
