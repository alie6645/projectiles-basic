package projectile.environment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Background {
    public Background(){
        add(new Rectangle(0,0,100,100));
        add(new Rectangle(400,400,100,100));
        add(new Rectangle(1000,1000,100,100));
        addTarget(new Rectangle(600,400,200,200));
        addEnemy(new Rectangle(500,1000,100,100));
    }
    List<Solid> walls = new ArrayList<>();
    public void draw(Graphics2D g2){
        for (Solid wall:walls){
            wall.draw(g2);
        }
    }

    public void update(int x, int y){
        for (int i=0; i<walls.size(); i++){
            Solid wall = walls.get(i);
            if (wall.visible == false){
                walls.remove(wall);
            }
            wall.update(x,y);
        }
    }

    // checks for wall collisions of a point, calls collision behavior
    public boolean collision(int x,int y){
        for (Solid wall:walls){
            if (wall.contains(x,y)){
                wall.setColor(Color.red);
                wall.timer(5);
                if (wall instanceof  Target){
                    ((Target) wall).hit();
                }
                return true;
            }
        }
        return false;
    }

    public void add(Shape shape){
        walls.add(new Solid(shape));
    }

    public void addTarget(Shape shape){
        walls.add(new Target(shape));
    }

    public void addEnemy(Shape shape){
        walls.add(new Enemy(shape));
    }
}
