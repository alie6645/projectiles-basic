package projectile.control;

import projectile.environment.Background;

import java.awt.*;
import java.util.ArrayList;

public class ProjectilePanel {
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public void add(Projectile projectile){
        projectiles.add(projectile);
    }

    public void setOffset(Point offset){}

    public void add(int x, int y, double xChange, double yChange, int lifetime){
        projectiles.add(new Projectile(x,y,xChange,yChange,lifetime));
    }

    public void update(int x, int y, Background background){
        for (Projectile proj:projectiles){
            proj.update(x,y);
            if (background.collision((int) proj.getX() + 400, (int) proj.getY() + 400)){
                proj.setVisible(false);
            }
        }

        for (int i=0; i< projectiles.size(); i++){
            Projectile proj = projectiles.get(i);
            if (!proj.getVisible()){
                projectiles.remove(proj);
            }
        }
    }

    public void draw(Graphics2D g2){
        for (Projectile proj:projectiles){
            proj.draw(g2);
        }
    }
}
