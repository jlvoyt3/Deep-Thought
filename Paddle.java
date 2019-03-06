/*
""" Title: Pong Game in Java
Author: Lazy Sloth 13
Date: June 9, 2013
Code Version: 1.0
Availability: http://interactivepython.org/runestone/static/StudentCSP/CSPCreativity/referencing.html
*/

import java.awt.Rectangle;
import java.awt.Graphics;


public class Paddle {
    private static final int width = 15, height = 125;
    private Pong game;
    private int upMove, downMove, x, y, yMovement;

    public Paddle(Pong game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.upMove = up;
        this.downMove = down;
    }

    public void update() {
        if (y > 0 && y < game.getHeight() - height - 40)
            y += yMovement;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - height - 30)
            y--;
    }

    public void pressed(int keyCode) {			
        if (keyCode == upMove)
            yMovement = -2;
        else if (keyCode == downMove)
            yMovement = 2;
    }

    public void released(int keyCode) {			// player non-movement
        if (keyCode == upMove || keyCode == downMove)
            yMovement = 0;
    }

    public Rectangle getBounds() {				// for collision
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics g) {				// displays the stuff
        g.fillRect(x, y, width, height);
    }
}
