/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopaint;

import javax.swing.JFrame;

/**
 *@author : Yuri Domingos 
   Data    : 18 - 12 - 2020
   Objectivo : Construir um programa como o paint do windows
 */
public class ProjectoPaint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Programa paint ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Cenario());
        frame.setSize(900, 600);
        frame.setVisible(true);
    }
    
}
