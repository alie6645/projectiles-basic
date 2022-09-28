package projectile;

import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int xChange;
    private int yChange;

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
        g2.fillOval(x-diameter/2,y-diameter/2,diameter,diameter);
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
}
