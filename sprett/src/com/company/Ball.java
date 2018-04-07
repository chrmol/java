package com.company;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Main spill;

    public Ball(Main spill){
        this.spill = spill;
    }

    void moveBall() {
    	if (x + xa < 0){
    		xa = spill.speed;
		} if (x + xa > spill.getWidth() - DIAMETER){
    		xa = - spill.speed;
		} if (y + ya < 0){
    		ya = spill.speed;
		} if (y + ya > spill.getHeight() - DIAMETER){
            spill.gameOver();
		} if (collision()){
    	    ya = - spill.speed;
    	    y = spill.racquet.getTopY() - DIAMETER;
    	    spill.speed++;
        }

        x = x + xa;
        y = y + ya;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    public void paint(Graphics2D g){
        g.fillOval(x, y, 30,30);
    }

    private boolean collision(){
        return spill.racquet.getBounds().intersects(getBounds());
    }

}
