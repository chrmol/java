package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;

	public Main() {
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}

    public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Sprett");
		Main spill = new Main();
		frame.add(spill);
		frame.setSize(300,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while(true) {
			spill.move();
			spill.repaint();
			Thread.sleep(10);
		}
    }

	@Override
	public void paint(Graphics g) {
		super.paint(g);
    	Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()),10,30);
	}

	private int getScore(){
		return speed - 1;
	}

	private void move(){
		ball.moveBall();
		racquet.move();
	}

	public void gameOver(){
		JOptionPane.showMessageDialog(this,"Din poengsum er: " + getScore(), "Game Over",JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

}
