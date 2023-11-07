/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

import data.dominio.DominoGame;

import java.util.List;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class MainMenuModelImpl implements MainMenuModel,MainMenuViewModel {
private DominoGame dominoGame;
private PlayerDTO myPlayer;
private WaitingRoomDTO waitingRoom;


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
  this.waitingRoom=waitingRoom;
        this.myPlayer = myPlayer;
     
    }
/**
 * Asigna al jugador como admin, en caso de que lo sea, 
 * y regresa la lista de jugadores actualizada.
 * @return 
 */
    @Override
    public List<PlayerDTO> setPlayerAdmin() {
      List<PlayerDTO> listaAct = null;
      PlayerDTO[] jugadores=new PlayerDTO[dominoGame.players.size()] ;
      
           for(int x=0;x<dominoGame.players.size();x++){
              jugadores[x].setId(dominoGame.players.elementAt(x).getValor());
              if(dominoGame.players.elementAt(x).getValor()== this.myPlayer.getId()){
                  jugadores[x].setIsAdmin(true);
              }else{
                   jugadores[x].setIsAdmin(false);
              }
              listaAct.add(jugadores[x]);
           }
         
                   return listaAct;
      
    
    }
/**
 * Actualiza la sala de espera, 
 * por lo general guando hay cambios
 * nuevos de fuera.
 */
    @Override
    public void setWaitingRoom() {
     waitingRoom=this.waitingRoom;
     
    }
/**
 * Inicializa al jugador de la sesión actual.
 * @param player 
 */
    @Override
    public void setMyPlayer(PlayerDTO player) {
      this.myPlayer=player;
              }
/**
 * En base a la lógica de negocio en el dominio,
 * regresar true si el estado de actual de la sala de espera
 * representa que el juego esta listo para iniciar.
 * @return 
 */
    @Override
    public boolean isReady() {
        if( waitingRoom.getPlayers().size()==4){
            return true;
        }
    return false;
    }
/**
 *  Regresa una lista con la información necesaria
 * para cargar Avatares.
 * @return 
 */
    @Override
    public List<AvatarDTO> getAvatars() {
        System.out.println("sin AvatarDTO");
      return null;
        
      }
/**
 * Regresa la información del jugador actual.
 * @return 
 */
    @Override
    public PlayerDTO getMyPlayer() {
     
              return this.myPlayer;
    }
/**
 * Regresa información de la sala de espera.
 * @return 
 */
    @Override
    public WaitingRoomDTO getWaitingRoom() {
       
    return this.waitingRoom;
            }
    
}
