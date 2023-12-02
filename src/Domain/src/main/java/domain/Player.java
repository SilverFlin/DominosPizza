package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un jugador en el juego.
 *
 * Esta clase implementa la interfaz Serializable para permitir la serialización
 * de objetos Player.
 */
public class Player implements Serializable {

    private List<PlayerTile> tilesInHand; // Lista de fichas en la mano del jugador
    private Avatar avatar; // Avatar asociado al jugador
    private boolean isAdmin; // Indica si el jugador es administrador
    private boolean isReady; // Indica si el jugador está listo para comenzar el juego

    /**
     * Constructor de la clase Player. Inicializa la propiedad isReady como
     * false por defecto.
     */
    public Player() {
        this.isReady = false;
        this.tilesInHand = new ArrayList<>();
    }

    /**
     * Obtiene la lista de fichas en la mano del jugador.
     *
     * @return Lista de fichas en la mano del jugador.
     */
    public List<PlayerTile> getTilesInHand() {
        return tilesInHand;
    }

    /**
     * Establece la lista de fichas en la mano del jugador.
     *
     * @param tilesInHand Nueva lista de fichas en la mano del jugador.
     */
    public void setTilesInHand(final List<PlayerTile> tilesInHand) {
        this.tilesInHand = tilesInHand;
    }

    /**
     * Obtiene el avatar asociado al jugador.
     *
     * @return Avatar asociado al jugador.
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar asociado al jugador.
     *
     * @param avatar Nuevo avatar asociado al jugador.
     */
    public void setAvatar(final Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * Verifica si el jugador es un administrador.
     *
     * @return Verdadero si el jugador es administrador, falso de lo contrario.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Establece si el jugador es administrador.
     *
     * @param isAdmin Nuevo valor que indica si el jugador es administrador.
     */
    public void setIsAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Agrega una ficha a la mano del jugador.
     *
     * @param tile Ficha de dominó a agregar a la mano del jugador.
     */
    public void addTile(final DominoTile tile) {
        this.tilesInHand.add((PlayerTile) tile);
    }

    /**
     * Elimina una ficha de la mano del jugador.
     *
     * @param tile Ficha de dominó a eliminar de la mano del jugador.
     */
    public void removeTile(final PlayerTile tile) {
        this.tilesInHand.remove(tile);
    }

    /**
     * Verifica si el jugador está listo para comenzar el juego.
     *
     * @return Verdadero si el jugador está listo, falso de lo contrario.
     */
    public boolean isReady() {
        return isReady;
    }

    /**
     * Establece que el jugador está listo para comenzar el juego.
     */
    public void setReady() {
        this.isReady = true;
    }

    /**
     * Establece que el jugador NO está listo para comenzar el juego.
     */
    public void setNotReady() {
        this.isReady = false;
    }
}
