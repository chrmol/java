package com.company;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Racquet {
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Main spill;

    public Racquet(Main spill){
        this.spill = spill;
    }

    public void move(){
        if(x + xa > 0 && x + xa < spill.getWidth() - 60){
            x = x + xa;
        }
    }
    public void paint(Graphics2D g){
        g.fillRect(x, 330,60,10);
    }
    public void keyReleased(KeyEvent e){
        xa = 0;
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            xa = - spill.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            xa = spill.speed;
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    public int getTopY(){
        return Y;
    }
}
