package projectile.Swing;

import projectile.environment.Background;
import projectile.control.Player;
import projectile.control.ProjectilePanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JComponent {
    private ProjectilePanel projectiles;
    private Player player;
    private Background background = new Background();

    public Panel(ProjectilePanel projectiles, Player player){
        this.projectiles = projectiles;
        projectiles.setOffset(getLocation());
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        background.draw(g2);
        projectiles.draw(g2);
        player.draw(g2);
    }

    //updates components each frame, also performs inter class calculations
    public void update(){
        background.update(player.getX(),player.getY());
        projectiles.update(player.getX(),player.getY(),background);

        //stops movement on player collision
        if (background.collision(player.getX()+400+player.getxChange(), player.getY()+400+player.getyChange())){
            player.setxChange(0);
            player.setyChange(0);
        }
        player.update();
        repaint();
    }
}
