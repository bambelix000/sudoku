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

    Timer timer = new Timer(90, this);

    BoardManager boardM = new BoardManager(this, 3);

    GamePanel(){
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(boardM);
        this.addKeyListener(boardM);
        timer.start();
    }

    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer) {
            repaint();
            if(boardM.howManyBlanks == 0){
                System.out.println("you won");
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        boardM.drawNumbers(g2);

    }


}
