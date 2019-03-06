import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Ball {
    private static final int width = 20, height = 20;
    private Pong game;
    private int x, y, xMovement = 2, yMovement = 2;

    public Ball(Pong game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    public void update() {
        x = x + xMovement;
        y = y + yMovement;
        if (x < 0) {												
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xMovement = -xMovement;
        }
        else if (x > game.getWidth() - width - 10) {				//if the ball scores on player2
            game.getPanel().increaseScore(2);						//increase score of player
            x = game.getWidth() / 2;
            xMovement = -xMovement;									//reflect x axis movement
        }
        else if (y < 0 || y > game.getHeight() - height - 35)		//if the ball hit the "roof" is reflects along y axis
            yMovement = -yMovement;
        
        Collision();
    }

    public void Collision() {										// if collision reflect along the x axis for movement
        if (game.getPanel().getPlayer(1).getBounds().intersects(getPosition()) || game.getPanel().getPlayer(2).getBounds().intersects(getPosition()))
            xMovement = -xMovement;
    }

    public Rectangle getPosition() {								// for collision analysis
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics g) {									//displays the stuff
        g.fillRect(x, y, width, height);
    }
}
