# Graphic Manager

## Clases

![Figure1](/docs/imgs/CD_graphic_manager.png)

_Figure 1. Diagrama de Clase Graphic Manager_

El diagrama editable se encuentra en [este link](https://drive.google.com/file/d/1oVkypOHVZoRctvRNdiAn43A0KUSMi_EH/view?usp=drive_link).

| Componente       | Definición                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ---------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| GraphicComponent | Es la interfaz base del patrón Composite. <ul><li>`draw():void`: Asegura que el componente se puede dibujar.<_/li></ul>                                                                                                                                                                                                                                                                                                                               |
| GraphicComposite | Visto como arbol, este es el nodo. Contiene otros componentes (que pueden o no ser Composite).<ul><li>`add(GraphicComponent component):void`: Itera en todos los componentes almacenados para que estos se dibujen (o también iteren).</li><li>`add(GraphicComponent component):void`: Agrega un componente a su lista de componentes.</li><li>`remove(GraphicComponent component):void`: Elimina un componente de su lista de componentes.</li></ul> |

Todos los demás componentes son hojas, es decir, no contienen otros componentes.

| Componente        | Definición                                                                                                                                                                                                                                           |
| ----------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| PlayerTileGraphic | Es la representación gráfica de una ficha de jugador. <ul><li>`PlayerTileGraphic(Tile tile, Point point)`: Contiene lo necesario para dibujarse, así como su posición.</li><li>`draw():void`: Dibuja la ficha en la posición especificada.</li></ul> |

### Notas

Los atributos de las clases de Dominio se pasan a las clases de Gráficos de forma segregada, para que estas puedan dibujarse.

Información adicional como la posición de la ficha, rotación, etc. se almacena en la clase `PlayerTileGraphic` y está sujeta a cambios.

### Referencias
1. https://refactoring.guru/design-patterns/composite