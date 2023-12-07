package dtos;

import java.util.List;

/**
 *
 */
public class PlayerDTO {

    private boolean isAdmin;
    private boolean isReady;
    private List<DominoDTO> tiles;
    private String name;
    private AvatarDTO avatar;

    public PlayerDTO() {
        this.isAdmin = false;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AvatarDTO getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarDTO avatar) {
        this.avatar = avatar;
    }

    public List<DominoDTO> getTiles() {
        return tiles;
    }

    public void setTiles(List<DominoDTO> tiles) {
        this.tiles = tiles;
    }

    public boolean isIsReady() {
        return isReady;
    }

    public void setIsReady(boolean isReady) {
        this.isReady = isReady;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" + "tiles=" + tiles + ", name=" + this.avatar.getNombre() + '}';
    }

}
