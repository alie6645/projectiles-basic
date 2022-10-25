package projectile.environment;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class Enemy extends Target {
    private final int speed = 5;
    private AffineTransform transform = new AffineTransform();

    public Enemy(Shape shape) {
        super(shape);
    }

    public void update(int x,int y){
        super.update(x,y);
        move(x,y);

    }

    public void move(int x, int y){
        int vectorX = getX() - (x+400);
        int vectorY = getY() - (y+400);
        double divisor = Math.sqrt(Math.pow(vectorX,2) + Math.pow(vectorY,2))/10;
        transform.setToTranslation(vectorX/divisor, vectorY/divisor);
        setShape(transform.createTransformedShape(getShape()));
    }
}
