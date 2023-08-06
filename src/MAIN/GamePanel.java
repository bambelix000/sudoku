package MAIN;

import BOARD.NumberManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public final int tileSize = 100;

    public final int boardWidth = tileSize * 9;
    public final int boardHeight = tileSize * 9;

    NumberManager numberM = new NumberManager(this);


    GamePanel(){
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        numberM.drawNumber(g2);

    }


}
