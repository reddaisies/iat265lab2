import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Ball {
	
	private int x, y, size, speedx;
	
	private Color ballColor;
	
	//construct a ball; middle point is center of ball
    public Ball(int x, int y, int size, int speedx, Color ballColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speedx = speedx;
        this.ballColor = ballColor;
    }
    
	public void draw(Graphics g) {
		g.setColor(ballColor);
		g.fillOval(x-size/2, y-size/2, size, size);
	}

	public void move() {
        x += speedx;
    }
    
    public void checkCollision(Dimension panelSize) {
        boolean leftHit = x - size/2 < 0; // x = center of ball; -size/2 (left border)
        boolean rightHit = x + size/2 > panelSize.width;
        if (leftHit || rightHit){
        	speedx = -speedx;
        	ballColor = new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200));
        }

    }

/*	private void randColor(int randColor, int randColor2, int randColor3) {
		// TODO Auto-generated method stub
		int randColor1 = (int) Math.random() * 10 + 5;		
		setColor(randColor1,randColor1,randColor1)
	}*/
}