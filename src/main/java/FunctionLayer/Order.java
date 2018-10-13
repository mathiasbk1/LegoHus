/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.HashMap;

/**
 *
 * @author Mathias
 */
public class Order {
    int id, width, length, height;
    HashMap<String, Integer> map; 
    boolean isShipped;

    public Order(int id, int width, int length, int height, HashMap<String,Integer> map, boolean isShipped) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.height = height;
        this.map = map;
        this.isShipped = isShipped;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }

    public boolean isIsShipped() {
        return isShipped;
    }
    
    
    
}
