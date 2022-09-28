package projectile;

import snake.SnakeKeys;
import snake.SnakePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ProjectilePanel projectiles = new ProjectilePanel();
        Player player = new Player(200,200);
        Panel panel = new Panel(projectiles,player);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(320,340));
        frame.setVisible(true);
        frame.add(panel);
        frame.addMouseListener(new ClickListener(projectiles,player));
        frame.addKeyListener(new MoveKeys(player));
        frame.revalidate();
        Timer timer = new Timer(15, e -> {
            panel.update();
        });
        timer.start();


    }
}