/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author : Yuri Domingos 
   Data    : 18 - 12 - 2020
   Objectivo : Construir um programa como o paint do windows
 */
public class Cenario  extends JPanel implements Runnable{
    
    private Graphics2D graphics2D;
    private ArrayList<Desenho> figura = null ;
    private boolean desenhando = true;

    private Thread thread ;

    public Cenario() {
        
        figura = new ArrayList<>();
        
        addMouseListener(new MouseListener() {
          
            public void mouseClicked(MouseEvent me) {
                  
               
            }

           
            public void mousePressed(MouseEvent me) {
                
              desenhando = true;
            }

           
            public void mouseReleased(MouseEvent me) {
                
                desenhando = false;
               
            }

     
            public void mouseEntered(MouseEvent me) {
              
            }

         
            public void mouseExited(MouseEvent me) {
               
            }
        });
        
        thread = new Thread(this);
        thread.start();
       
  
        
    }
    
    
    
    
    public void paintComponent(Graphics g)
    {
         super.paintComponent(g);
        
         graphics2D = (Graphics2D) g.create();
         
         this.setBackground(Color.WHITE);
         
         graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Esta é linha que deixa o desenho mais puro cota geraldo 
         graphics2D.setFont(new Font("Serief", Font.BOLD,25));
         graphics2D.fill(new Rectangle2D.Double(80,15,200,50));
         graphics2D.setColor(Color.YELLOW);
         graphics2D.drawString("PAINT", 124,50);
         
         
         graphics2D.setColor(Color.BLACK);
         
         for ( int i = 1; i < figura.size(); i++)
         {
            int x   = figura.get(i).getX();
            int y   = figura.get(i).getY();
            int x2  = figura.get(i-1).getX();
            int y2  = figura.get(i-1).getY();
            
              graphics2D.drawLine(x2,y2 , x, y);
            
            //graphics2D.fill(new Line2D.Double(x2,y2 , x, y));
            
        }
        
        g.dispose();
        
        
    }

   
    @Override
    public void run() {
        
        while(true)
        {
            
            if (desenhando)
            {
                 
                try {
            
                      Point meus_movimentos = getMousePosition();
                      figura.add(new Desenho( meus_movimentos.x, meus_movimentos.y)); 
                
                
                    }catch(Exception ex) { /*JOptionPane.showMessageDialog(null, ex);*/  } 
                
            }
           
                repaint();  
                
        }      
    }
}
