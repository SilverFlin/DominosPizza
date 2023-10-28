# Ejercer Turno

## Clases

![Figure1](/docs/imgs/CD_ejercer_turno.png)

Figure 1. Diagrama de Clase Ejercer Turno

| Componente    | Definicion                                                                                                                                                                                                                                                                                                                                                                                    |
| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| DominoDTO     | <p>Data Transfer Object con la información que la vista necesita enviar al Presentador para poder referenciar las interacciones de fichas.</p><ul><li>`leftValue` _int_: Valor izquierdo de la ficha<li>`rightValue` _int_: Valor derecho de la ficha.</ul>                                                                                                                                   |
| GameView      | <p>Es la interfaz de la Vista, del patrón MVP. <br> Su función es repsentar todos los cambios solicitados por el Presentador, de forma gráfica.</p><ul><li>`showInvalidError`_():void_: Despliega un mensaje de error.</li><li>`updateGame`_(GameViewModel model):void_: Actualiza todo el juego, obteniendo la información del Modelo el cual es proporcionado por el Presentador.</li></ul> |
| GameJFrame    | <p>Implementación de la interfaz `GameView`, la cual lo hace mediante los JFrame de Java.</p>                                                                                                                                                                                                                                                                                                 |
| GamePresenter | <p>Es la interfaz del Presentador, del patrón MVP. <br> Refleja los cambios de información en el Modelo y le dice a la Vista cómo comportarse.</p><ul><li>`putTileInBoard`_(): void_: Sirve para recibir el cambio de la vista. Aquí el Presentador actualiza al Modelo con la ficha regresada y vuelve a cargar la vista con los datos actualizados.</li></ul>                               |

## Secuencia

### Ejercer Turno

![Figure2](/docs/imgs/SD_ejercer_turno.png)

Figure 2. Diagrama de Secuencia: Ejercer Turno

| Componente | Definicion                                                                                         |
| ---------- | -------------------------------------------------------------------------------------------------- |
| Clase1     | <p>Descripcion de la clase</p><ul><li>`function_name` _(type)_: function desc<li><li><li><li></ul> |

### Actualizar Juego

![Figure3](/docs/imgs/SD_update_game.png)

Figure 3. Diagrama de Secuencia: Actualizar Juego

| Componente | Definicion                                                                                         |
| ---------- | -------------------------------------------------------------------------------------------------- |
| Clase1     | <p>Descripcion de la clase</p><ul><li>`function_name` _(type)_: function desc<li><li><li><li></ul> |