package projectile;

import java.awt.*;

public class Projectile {
    private double xChange;
    private double yChange;
    private double x;
    private double y;
    private int lifetime;
    private int diameter = 5;
    private boolean visible = true;

    public Projectile(int x, int y, double xChange, double yChange, int lifetime){
        this.x = x;
        this.y = y;
        this.xChange = xChange;
        this.yChange = yChange;
        this.lifetime = lifetime;
    }

    public void update(){
        x += xChange;
        y += yChange;
        lifetime -= 1;
        if (lifetime == 0){
            visible = false;
        }
    }

    public void draw(Graphics2D g2){
        if (visible) {
            g2.setColor(Color.RED);
            g2.fillOval((int)x - ((diameter + 1) / 2), (int)y - ((diameter + 1) / 2), diameter, diameter);
        }
    }

    public boolean getVisible(){
        return visible;
    }
}
