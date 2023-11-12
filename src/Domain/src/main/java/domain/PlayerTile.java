package domain;

import java.io.Serializable;

/**
 *
 */
public class PlayerTile extends DominoTile implements Serializable {

    public PlayerTile(int leftValue, int rightValue) {
        super(leftValue, rightValue);
    }

}
