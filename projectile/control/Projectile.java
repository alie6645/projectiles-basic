package projectile.control;

import java.awt.*;
import java.awt.geom.Line2D;

public class Projectile {
    private double xChange;
    private double yChange;
    private double x;
    private double y;
    private int lifetime;
    private int diameter = 5;
    private boolean visible = true;
    private Line2D.Double ray;
    private int playerX;
    private int playerY;

    public Projectile(int x, int y, double xChange, double yChange, int lifetime){
        this.x = x;
        this.y = y;
        this.xChange = xChange;
        this.yChange = yChange;
        this.lifetime = lifetime;
        this.ray = new Line2D.Double(x,y,x+xChange,y+yChange);
    }

    public void update(int playerx, int playery){
        x += xChange;
        y += yChange;
        lifetime -= 1;
        if (lifetime == 0){
            visible = false;
        }
        ray.setLine(x,y,x+xChange,y+yChange);
        this.playerX = playerx;
        this.playerY = playery;
    }

    public void draw(Graphics2D g2){
        if (visible) {
            g2.setColor(Color.RED);
            g2.fillOval((int)x - ((diameter + 1) / 2) - playerX + 400, (int)y - ((diameter + 1) / 2) - playerY + 400, diameter, diameter);
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean getVisible(){
        return visible;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
