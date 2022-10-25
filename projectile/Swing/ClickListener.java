package projectile.Swing;

import projectile.control.Player;
import projectile.control.ProjectilePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {
    ProjectilePanel panel;
    Player player;
    final double speed = 5;
    double angle;
    public ClickListener(ProjectilePanel panel, Player player){
        this.panel = panel;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (int i=0; i<4; i++) {
            double vectorX = (x - player.getPosition().getX());
            double vectorY = (y - player.getPosition().getY());
            //To match speed
            double divisor = (Math.sqrt(Math.pow(vectorX, 2) + Math.pow(vectorY, 2))) / speed;
            double random = (i-2);
            double angle = Math.atan(vectorY/vectorX);
            double yspread = random * Math.cos(angle);
            double xspread = -random * Math.sin(angle);
            panel.add(player.getX(), player.getY(), vectorX / divisor + xspread, vectorY / divisor + yspread, 80);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
