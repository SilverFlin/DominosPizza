/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itson.eventschema;

import domain.DominoGame;

/**
 *
 * @author edemb
 */
public class StartGameEvent extends Event<DominoGame>{
    
    /**
     * Constructor del evento de StartGameEvent
     * @param payload Datos a pasar que es la informacion del Juego
     */
    public StartGameEvent(final DominoGame payload) {
        super(payload);
        this.type = EventType.START_GAME;
    }
    
}
