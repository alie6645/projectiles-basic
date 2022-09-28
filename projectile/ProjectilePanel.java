package projectile;

import java.awt.*;
import java.util.ArrayList;

public class ProjectilePanel {
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public void add(Projectile projectile){
        projectiles.add(projectile);
    }

    public void add(int x, int y, double xChange, double yChange, int lifetime){
        projectiles.add(new Projectile(x,y,xChange,yChange,lifetime));
    }

    public void update(){
        for (Projectile proj:projectiles){
            proj.update();
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
