package domain;

import java.io.Serializable;

/**
 * Clase que representa la configuración del juego.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Config.
 */
public class Config implements Serializable {

    private int tilesPerPlayer; // Número de fichas por jugador

    /**
     * Constructor de la clase Config.
     */
    public Config() {
    }

    /**
     * Obtiene el número de fichas por jugador.
     *
     * @return Número de fichas por jugador.
     */
    public int getTilesPerPlayer() {
        return tilesPerPlayer;
    }

    /**
     * Establece el número de fichas por jugador.
     *
     * @param tilesPerPlayer Nuevo número de fichas por jugador.
     */
    public void setTilesPerPlayer(final int tilesPerPlayer) {
        this.tilesPerPlayer = tilesPerPlayer;
    }

}
