package projectile.Swing;

import projectile.control.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MoveKeys extends KeyAdapter {
    Player player;

    public MoveKeys(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //right
        if (e.getKeyCode()==39){
            player.setxChange(2);
        }
        //left
        if (e.getKeyCode()==37){
            player.setxChange(-2);
        }
        //up
        if (e.getKeyCode()==38){
            player.setyChange(-2);
        }
        //down
        if (e.getKeyCode()==40){
            player.setyChange(2);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==39){
            player.setxChange(0);
        }
        //left
        if (e.getKeyCode()==37){
            player.setxChange(0);
        }
        //up
        if (e.getKeyCode()==38){
            player.setyChange(0);
        }
        //down
        if (e.getKeyCode()==40){
            player.setyChange(0);
        }
    }
}