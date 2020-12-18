/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopaint;

/**
 *
 * @author : Yuri Domingos 
   Data    : 18 - 12 - 2020
   Objectivo : Construir um programa como o paint do windows
 */
public class Desenho {
    
    private int x;
    private int y;
    

    public Desenho(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
}
