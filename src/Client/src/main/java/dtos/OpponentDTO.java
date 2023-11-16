package dtos;

/**
 *
 */
public class OpponentDTO {

    private boolean isAdmin;
    private int tilesLeft;
    private String name;
    private AvatarDTO avatar;

    public OpponentDTO() {
        this.isAdmin = false;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getTilesLeft() {
        return tilesLeft;
    }

    public void setTilesLeft(int tilesLeft) {
        this.tilesLeft = tilesLeft;
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

}
