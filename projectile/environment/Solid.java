package projectile.environment;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Solid {
    private Color color = Color.BLACK;
    private Shape shape;
    private AffineTransform transform = new AffineTransform();
    private int timer = 0;
    public boolean visible = true;


    public Solid(Shape shape){
        this.shape = shape;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void update(int x, int y){
        transform.setToTranslation(-x,-y);
        if (timer == 0){
            setColor(color = Color.BLACK);
        } else {
            timer -= 1;
        }
    }

    public boolean contains(int x,int y){
        return shape.contains(x,y);
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fill(transform.createTransformedShape(shape));
    }

    public int getX(){
        return (int) shape.getBounds().getX();
    }

    public int getY(){
        return (int) shape.getBounds().getY();
    }

    public void timer(int time){
        timer = time;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
