package MAIN;

import BOARD.BoardManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    public final int tileSize = 100;

    public final int boardWidth = tileSize * 9;
    public final int boardHeight = tileSize * 9;

    Timer timer = new Timer(5000, this);

    BoardManager boardM = new BoardManager(this, 3);

    GamePanel(){
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(boardM);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        boardM.drawNumber(g2);


    }
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer) {

            boardM.loadBoard("/BOARDS/game.txt");
            repaint();
            System.out.println("done");

        }

    }
}
