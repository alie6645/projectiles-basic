package projectile;

import javax.swing.*;
import java.awt.*;

public class Panel extends JComponent {
    private ProjectilePanel projectiles;
    private Player player;

    public Panel(ProjectilePanel projectiles, Player player){
        this.projectiles = projectiles;
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        projectiles.draw(g2);
        player.draw(g2);
    }

    public void update(){
        projectiles.update();
        player.update();
        repaint();
    }
}
