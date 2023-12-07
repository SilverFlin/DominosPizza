package dtos;

/**
 *
 */
public class OpponentDTO {

    private boolean isAdmin;
    private int tilesLeft;
    private AvatarDTO avatar;

    public OpponentDTO() {
        this.isAdmin = false;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(final boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getTilesLeft() {
        return tilesLeft;
    }

    public void setTilesLeft(final int tilesLeft) {
        this.tilesLeft = tilesLeft;
    }

    public AvatarDTO getAvatar() {
        return avatar;
    }

    public void setAvatar(final AvatarDTO avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "OpponentDTO{" + "tilesLeft=" + tilesLeft + ", name=" + this.avatar.getNombre() + '}';
    }

}
