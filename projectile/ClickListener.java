package projectile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {
    ProjectilePanel panel;
    Player player;
    final double speed = 40;
    public ClickListener(ProjectilePanel panel, Player player){
        this.panel = panel;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int vectorX = x-player.getX();
        int vectorY = y-player.getY();
        //To match speed
        double divisor = (Math.sqrt(Math.pow(vectorX,2) + Math.pow(vectorY,2)))/speed;
        panel.add(player.getX(),player.getY(),vectorX/divisor,vectorY/divisor,20);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
