/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.eventschema;

import domain.Player;

/**
 * @author Victor
 * @version IDE 17
 */
public class PlayerReadyEvent extends Event<Player> {
    // CONSTRUCTORES
    /**
     * Constructor de la clase PlayerReadyEvent
     * @param payload Objeto Player que indica el estado actual del jugador
     */
    public PlayerReadyEvent(final Player payload) {
        super(payload);
        this.type = EventType.PLAYER_READY;
    }
}