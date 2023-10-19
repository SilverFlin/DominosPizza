/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui.MainMenu;

import ui.base.View;

/**
 *
 * @author edemb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MenuPrincipal vista = new MenuPrincipal();
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setBounds(0, 0, 1280, 800);
        menuPanel.setVisible(false);
        ConfigurationPanel configPanel =  new ConfigurationPanel();
        configPanel.setVisible(false);
        configPanel.setBounds(0, 0, 1280, 800);
        vista.addPanel(menuPanel);
        vista.addPanel(configPanel);

    }

}
