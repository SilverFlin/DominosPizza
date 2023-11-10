/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphicmanager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIVB
 */
public class GraphicComposite {
    
    
    List<GraphicComponent> components;

    public GraphicComposite() {
        components = new ArrayList<>();
    }

    public void add(GraphicComponent gc){
        components.add(gc);
    }
    
    public void remove(GraphicComponent gc){
        components.remove(gc);
    }
    
    public void draw(){
        for (var component : components) 
            component.draw();
    }
    
}
