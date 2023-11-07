/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

/**
 *
 * @author edemb
 */
public class PlayerDTO {
    private boolean isAdmin;
    private int id;

    public PlayerDTO() {
    }

    public PlayerDTO(boolean isAdmin, int id) {
        this.isAdmin = isAdmin;
        this.id = id;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
