/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.game;

import data.dominio.DominoGame;
import data.dominio.Player;
import java.util.List;

/**
 *
 * @author JIVB
 */
public class GameModelImpl implements GameModel,GameViewModel{
    
    DominoGame dominoGame;
    Player myPlayer;

    public GameModelImpl() {
    }

    @Override
    public DominoDTO getTileFromPool() {
        return dominoGame.getPool().getDominoes().getLast();
    }

    @Override
    public void putTileInBoard(DominoDTO domino) {
        dominoGame.getPool().addTile(domino);
    }

    @Override
    public void takeFromPool(PlayerDTO player) {
        
    }

    @Override
    public void updateGame(GameDTO game) {
        
    }

    @Override
    public BoardDTO getBoard() {
        return dominoGame.getBoard();
    }

    @Override
    public PlayerDTO PlayerDTO() {
        
    }

    @Override
    public int getRemainigTileInPool() {
        return dominoGame.getPool().getDominoes().size();
    }

    @Override
    public List<PlayerDTO> getRoom() {
        return dominoGame.getPlayers();
    }
    
}
