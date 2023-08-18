package MAIN;

import BOARD.BoardManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public final int tileSize = 100;

    public final int boardWidth = tileSize * 9;
    public final int boardHeight = tileSize * 9;

    BoardManager boardM = new BoardManager(this, 3);

    GamePanel(){
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(boardM);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        boardM.drawNumber(g2);

    }
}
