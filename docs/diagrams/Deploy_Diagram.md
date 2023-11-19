![Figure1](/docs/imgs/Deploy_Diagram.png)

_Figure 1. Diagrama de Despliegue_

El diagrama editable se encuentra en [este link](https://drive.google.com/file/d/1A-LOgGoIk5m_glBIHTbAt7--g9Apd7BP/view?usp=drive_link).

El juego va a estar siendo manejado bajo un Servidor, el cual va a poder contener hasta 4 Clientes al mismo tiempo. Esta conexión se realizará bajo el protocolo TCP, utilizando Sockets.


| Componente  | Definición                                                                                                                                                | Requerimiento de instalación                                                                                                                                                                                                                                                                                                                   |
| ----------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Servidor    | Servidor de Dominó. <br> El Servidor va a estar manejando los eventos que se envíen desde los Clientes, y va a estar enviando los eventos a los Clientes. | Este componente necesita tener importado, ya sea mediante Jars o dependencias de Maven, los dos componentes de los cual depende. <br> <br>Una vez importados se puede, opcionalmente, configurar el puerto que va a estar utilizando (Default `6666`) en la clase Main `App.java`, en el constructor de la clase `Server`                      |
| Cliente     | Cliente de Dominó. <br> El Cliente va a estar manejando los eventos que se envíen desde el Servidor, y va a estar enviando los eventos al Servidor.       | Este componente necesita tener importado, ya sea mediante Jars o dependencias de Maven, los dos componentes de los cual depende. <br> <br> Una vez importados se deberá establecer la dirección IP y puerto del servidor (Default `127.0.0.1`, y `6666`) en la clase Main `App.java`, en el constructor de la clase `NetworkServerConnection`. |
| EventSchema | Esquema de los eventos que se van a estar enviando entre el Servidor y los Clientes.                                                                      | Este componente debe tener importado el Componente `Domain`.                                                                                                                                                                                                                                                                                   |
| Domain      | Dominio del juego, contiene las reglas del juego y las clases necesarias para poder jugar.                                                                | Este componente no necesita instalación.                                                                                                                                                                                                                                                                                                       |


## Referencias
- [Diagrama de Componentes](/docs/diagrams/Components_Diagram.md)