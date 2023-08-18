package MAIN;

import BOARD.NumberManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel{

    public final int tileSize = 100;

    public final int boardWidth = tileSize * 9;
    public final int boardHeight = tileSize * 9;

    NumberManager numberM = new NumberManager(this, 3);

    JLabel label;

    GamePanel(){
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        label = new JLabel();
        label.setBounds(0, 0 , 200,200);
        label.setOpaque(true);

        this.add(label);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        numberM.drawNumber(g2);

    }


}
