/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.base;

import ui.MainMenu.MainMenuView;

/**
 *
 * @author Toled
 * @param <V>
 */
public interface BasePanel<V extends MainMenuView> {

    void setView(final V view);
}
