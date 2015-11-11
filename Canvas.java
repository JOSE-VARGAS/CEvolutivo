/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author jose
 */
public class Canvas extends JFrame{
    
    BufferedImage img;
    int x , y;    
    Graphics g;    
    public Canvas(BufferedImage img){
        
        this.img = img;
        x = img.getHeight();
        y = img.getWidth();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        
    }

    public void paint(Graphics g) {
        //super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(img,x,x, null);
    }
    protected void paintComponent(Graphics g) {
     //super.paintComponent(g);// <-- let panel draw itself
     g.drawImage(img,x,x, null);  
  }
}
