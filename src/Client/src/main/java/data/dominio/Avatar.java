/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.dominio;

/**
 *
 * @author edemb
 */
public class Avatar {
    // ATRIBUTOS
    String name;
    String image;

    // CONSTRUCTORES
    /**
     * Constructor por default
     */
    public Avatar() {
    }

    // GETTERS & SETTERS
    /**
     * Método que obtiene el nombre del avatar
     * @return El nombre del avatar
     */
    public String getName() {
        return name;
    }
    /**
     * Método que asigna un nombre al avatar
     * @param name Nombre a asignar
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método que obtiene la foto de perfil del avatar
     * @return
     */
    public String getImage() {
        return image;
    }
    /**
     * Método que asigna una foto de perfil al avatar
     * @param image Imagen a asignar
     */
    public void setImage(String image) {
        this.image = image;
    }

    // MÉTODOS
    /**
     * Método que dibuja el avatar en el frame
     * @throws Exception
     */
    public void paint() throws Exception{
        throw new Exception("No sirve wey!!!!!!");
    }
}