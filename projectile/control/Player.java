package projectile.control;

import java.awt.*;
import java.awt.geom.Point2D;

public class Player {
    private int x;
    private int y;
    private int xChange;
    private int yChange;

    private Point2D position = new Point(400,400);

    final int diameter = 20;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(){
        x += xChange;
        y += yChange;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.orange);
        g2.fillOval(400 - diameter/2,400 - diameter/2,diameter,diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setxChange(int xChange) {
        this.xChange = xChange;
    }

    public void setyChange(int yChange) {
        this.yChange = yChange;
    }

    public int getxChange() {
        return xChange;
    }

    public int getyChange() {
        return yChange;
    }

    public Point2D getPosition() {
        return position;
    }
}
