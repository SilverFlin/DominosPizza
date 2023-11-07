/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.MainMenu;

/**
 *
 * @author edemb
 */
public class MainMenuPresenterImpl implements MainMenuPresenter{

    MainMenuView view;
    MainMenuModel model;
    
    public MainMenuPresenterImpl() {
    }

    public MainMenuPresenterImpl(MainMenuView view, MainMenuModel model) {
        this.view = view;
        this.model = model;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    
    
    
    @Override
    public void goToAvatarPanel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void goToWaitingRoom(PlayerDTO player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showInvalidNameError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateWaitingRoom() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
