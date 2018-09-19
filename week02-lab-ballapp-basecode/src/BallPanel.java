import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class BallPanel extends JPanel implements ActionListener {
	
	private Ball ball;
	private Timer t;
	
	public BallPanel(Dimension initialSize) {
        super();
        
        //randomize and type-cast speed of ball
        //only used inside of constructor, so only declare inside
        int randomSpeed = (int) (Math.random() * 10 - 10); 
        	//math.random() returns value from 0 to 1, so need to multiply by 10 to get a usable speed
        	//-5 because we need a range from -5 to 5
        	//converts double into integer
        
        //print the speed to console to debug
        System.out.println(randomSpeed); 
        ball = new Ball(initialSize.width/2, 
        				initialSize.height/2, 
                        Math.min(initialSize.width,initialSize.height)/10, 
                        randomSpeed,
                        new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200))); //pass new randomized value as the speed
        t = new Timer(33, this);
        t.start();
    }


	@Override //this method is a method of JPanel; not originally declared in BallPanel itself
	//taking it out will not affect program; only serves as an indicator
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //refreshes system
		setBackground(Color.black); // draws a black background
		ball.draw(g); //calls the ball
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        ball.checkCollision(this.getSize());
        repaint();
    }
}
