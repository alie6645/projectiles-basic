package projectile.environment;

import java.awt.*;

public class Target extends Solid{
    private final int max = 100;
    private int current = 100;
    private int width;
    private int height;
    Rectangle bar = new Rectangle(getX(),getY() - 22,110,20);
    Rectangle innerBar = new Rectangle(getX() + 5, getY() - 20, current, 16);

    public Target(Shape shape) {
        super(shape);
        width = (int) shape.getBounds2D().getWidth();
        height = (int) shape.getBounds2D().getHeight();

    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        g2.setColor(Color.BLACK);
        g2.fill(getTransform().createTransformedShape(bar));
        g2.setColor(Color.RED);
        g2.fill(getTransform().createTransformedShape(innerBar));
    }

    public void update(int x, int y){
        super.update(x,y);
        innerBar.setRect(getX() + 5,getY() - 20,current,16);
        bar.setRect(getX(),getY() - 22,110,20);
        if (current == 0){
            visible = false;
        }

    }

    public void hit(){
        current -= 10;
    }
}
