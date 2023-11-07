/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciarPartida;

import dominio.DominoGame;
import dominio.Player;
import java.util.List;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class MainMenuModelImpl implements MainMenuModel,MainMenuViewModel {
private DominoGame dominoGame;
private PlayerDTO myPlayer;

    public MainMenuModelImpl(DominoGame dominoGame, PlayerDTO myPlayer) {
        this.dominoGame = dominoGame;
        this.myPlayer = myPlayer;
    }

    public DominoGame getDominoGame() {
        return dominoGame;
    }

    public void setDominoGame(DominoGame dominoGame) {
        this.dominoGame = dominoGame;
    }

    

/**
 *  Crea el seguimiento a las instancias 
 *  del jugador actual y de la sala de espera.
 * @param myPlayer
 * @param waitingRoom 
 */    
    @Override
    public void configurateWaitingRoom(PlayerDTO myPlayer, WaitingRoomDTO waitingRoom) {
    this.myPlayer=myPlayer;
     
    }

    @Override
    public List<PlayerDTO> setPlayerAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setWaitingRoom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setMyPlayer(PlayerDTO player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isReady() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AvatarDTO> getAvatars() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PlayerDTO getMyPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WaitingRoomDTO getWaitingRoom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
