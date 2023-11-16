package ui.game;

/**
 *
 */
public class GameViewStub implements GameView {

    public GameViewStub() {
    }

    @Override
    public void showInvalidMoveError() {
        System.out.println("GameViewStub.invalidMoveError");
    }

    @Override
    public void updateGame(GameViewModel gameViewModel) {
        System.out.println("GameViewStub.updateGame");
    }

}
