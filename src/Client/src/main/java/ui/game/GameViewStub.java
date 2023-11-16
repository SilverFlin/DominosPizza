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

    @Override
    public void open() {
        System.out.println("GameViewStub.open");
    }

    @Override
    public void close() {
        System.out.println("GameViewStub.close");
    }

}
