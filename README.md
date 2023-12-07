# DominosPizza

## Getting Started 

### Prerequisitos

Para poder correr el proyecto se necesita tener instalado el JDK 17+, NetBeans 17.0+, Maven 3.8.1+ y ganas de jugar Dominó.

### Instalación

Para poder instalar el proyecto se necesita clonar el repositorio, y abrir los cuatro proyectos en NetBeans.

Las dependencias de Maven se deberían configurar e instalar automáticamente, pero si no se instalan se puede hacer click derecho en el proyecto, y seleccionar la opción `Add Dependency...`.

![Add Dependency](/docs/imgs/instalacion1.png)

En la ventana que se abre, se debe buscar la dependencia que se necesitan, establecidas en el [diagrama de despliegue](/docs/diagrams/Deploy_Diagram.md).



Una vez todo buildeado, se debe ubicar el proyecto de [Server](/src/Server/) y correrlo a través de `edu.itson.server.App.java`

Antes de correr el Cliente, se debe configurar la dirección IP del servidor, esto se hace en el archivo [App.java](/src/Client/src/main/java/client/App.java), en la línea 37.

```java
NetworkEventConnection eventConnection = new NetworkEventConnection("127.0.0.1", 6666);
```
Por default viene apuntando a localhost, pero se puede cambiar a la dirección IP del servidor.

Para conseguir la IP se debe asegurar que los dispositivos donde se va a correr el Cliente y el Servidor estén bajo el mismo router, y correr el siguiente comando en la terminal:

```bash
ipconfig
```

En la salida del comando se debe buscar la dirección IPv4 del dispositivo (que corre el server), y esa es la dirección IP que se debe utilizar.

Una vez configurada la dirección IP, se debe correr el proyecto de [Client](/src/Client/) a través de `client.App.java`

## Descripción

DominosPizza es un juego de dominó en línea, en el cual los jugadores podrán jugar partidas de dominó en línea con otros jugadores.

El juego cuenta con un sistema de sala de espera, en el cual los jugadores podrán esperar a que se llene la sala (máximo 4 jugadores) para poder jugar, o iniciarla voluntariamente con al menos dos jugadores.

El juego cuenta con un sistema de avatares, en el cual los jugadores podrán elegir un avatar para representarlos en el juego.

## Estilo arquitectónico

El estilo arquitectónico utilizado es el de [Event-Driven Architecture (EDA)](https://en.wikipedia.org/wiki/Event-driven_architecture), el cual se basa en el envío de eventos entre componentes, los cuales pueden ser consumidos por otros componentes.

En este estilo arquitectónico, los componentes pueden enviar eventos a otros componentes sin necesidad de conocerlos, esto permite que los componentes sean independientes entre sí. En el contexto de DominoGame, esto permite que los componentes del cliente puedan enviar eventos a otros clientes, a través del servidor, sin necesidad de conocerlos.

Por ejemplo, un cliente podría mandar un evento de que un jugador se unió a la sala de espera, y el servidor podría enviar ese evento a todos los clientes conectados, sin necesidad de que el cliente que envió el evento conozca a los demás clientes.

Esto igual necesitó establecer una estructura de los eventos, este se puede ver reflejado en el diagrama de [EventSchema](/docs/diagrams/EventSchema.md).

Para poder llevar a cabo el estilo arquitectónico se utilizó el patrón de diseño [Observer](https://en.wikipedia.org/wiki/Observer_pattern), el cual permite que un objeto notifique a otros objetos cuando un evento ocurre. Este patrón fue utilizado al recibir eventos en el [Servidor](/docs/diagrams/Server_Network_Manager.md) y en el [Procesador de Eventos](/docs/diagrams/Event_Processor.md), dentro del cliente.

## Documentación

La documentación del proyecto se encuentra en la carpeta [docs](/docs/README.md), en la cual se encuentra la documentación de la arquitectura, la documentación de los diagramas, la documentación de los DTOs, y la documentación de los eventos.
