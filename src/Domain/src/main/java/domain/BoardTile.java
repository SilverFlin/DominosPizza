package domain;

import java.io.Serializable;

/**
 *
 */
public class BoardTile extends DominoTile implements Serializable{

    public BoardTile(int leftValue, int rightValue) {
        super(leftValue, rightValue);
    }

}
