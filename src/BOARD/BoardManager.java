package BOARD;

import MAIN.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Random;

import static javax.imageio.ImageIO.read;

public class BoardManager extends MouseAdapter implements KeyListener {

    GamePanel gp;
    Number[] number;
    int[][] tileBoard;
    int mistakes = 0;
    int selectedX = 10;
    int selectedY = 10;
    public int howManyBlanks;



    public BoardManager(GamePanel gp, int maxBoardNum) {
        this.gp = gp;
        number = new Number[100];
        int randomNum = randomNumber(maxBoardNum);
        getNumber();
        tileBoard = new int[gp.boardWidth][gp.boardHeight];
        loadBoard("/BOARDS/board0" + randomNum + ".txt");
    }

     int randomNumber(int max){
        Random rand = new Random();
        int random = rand.nextInt(max);
        return  random + 1;
    }



    public void getNumber(){
        try{
            number[0] = new Number();
            number[0].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/blank.png")));

            number[1] = new Number();
            number[1].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/1.png")));

            number[2] = new Number();
            number[2].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/2.png")));

            number[3] = new Number();
            number[3].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/3.png")));

            number[4] = new Number();
            number[4].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/4.png")));

            number[5] = new Number();
            number[5].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/5.png")));

            number[6] = new Number();
            number[6].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/6.png")));

            number[7] = new Number();
            number[7].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/7.png")));

            number[8] = new Number();
            number[8].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/8.png")));

            number[9] = new Number();
            number[9].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/9.png")));

            number[10] = new Number();
            number[10].image = read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/selected.png")));

            number[11] = new Number();
            number[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a1.png")));

            number[12] = new Number();
            number[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a2.png")));

            number[13] = new Number();
            number[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a3.png")));

            number[14] = new Number();
            number[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a4.png")));

            number[15] = new Number();
            number[15].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a5.png")));

            number[16] = new Number();
            number[16].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a6.png")));

            number[17] = new Number();
            number[17].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a7.png")));

            number[18] = new Number();
            number[18].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a8.png")));

            number[19] = new Number();
            number[19].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/NUMBERS/a9.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }



    public void loadBoard(String filePath){
        try{
            int tmp = 0;
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));


            for(int j=0; j<9; j++) {
                String line = br.readLine();
                for(int i = 0; i<9;i++){
                    String[] number = line.split(" ");
                    int num = Integer.parseInt(number[i]);
                    if(num == 0 ){
                        tmp++;
                    }
                    tileBoard[i] [j] = num;
                }
            }
             howManyBlanks = tmp;
            System.out.println(howManyBlanks);

            br.close();

        }catch(Exception e){
            System.out.println("connecting with file was not possible, check if you provided appropriate file path");
        }
    }

    public void drawNumbers(Graphics2D g2){

        for(int y = 0; y<gp.boardHeight; y++){
            for(int x = 0; x<gp.boardWidth; x++){
                int num = tileBoard[x][y];

                int boardX = x * gp.tileSize;
                int boardY = y * gp.tileSize;

                if(num == 1 || num ==11){
                  g2.drawImage(number[num].image, boardX + 25, boardY + 5 , gp.tileSize - 50, gp.tileSize - 10, null);
              }else{
                  g2.drawImage(number[num].image, boardX + 7, boardY + 5, gp.tileSize - 15, gp.tileSize - 10, null);
              }
            }
        }
    }

    void tileClicked(int x, int y){
        if(tileBoard[x][y]>10){
            howManyBlanks++;
            System.out.println(howManyBlanks);
        }

        if(tileBoard[x][y] == 0 || tileBoard[x][y] > 10){
            tileBoard[selectedX][selectedY] = 0;
            tileBoard[x][y] = 10;
            selectedX = x;
            selectedY = y;

        }else if(tileBoard[x][y] == 10){
            tileBoard[x][y] = 0;
            selectedX = 10;
            selectedY = 10;
        }


    }
    public boolean numCheck(int x, int y, int value){
        //check if there is same number in col
        if(x<10 && y <10) {
            for (int i = 0; i < 9; i++) {
                if (tileBoard[x][i] == value || tileBoard[x][i] == value + 10 && i != y) {
                    System.out.println("problem z kolumn¹");
                    return false;
                }
            }

            //check if there is same number in row
            for (int j = 0; j < 9; j++) {
                if (tileBoard[j][y] == value || tileBoard[j][y] == value + 10 && j != x) {
                    System.out.println("problem z rzêdem");
                    return false;
                }
            }
            //check if there is same number in 3x3
            for (int g = 0; g < 9; g++) {
                int row = 3 * (x / 3) + (g / 3);
                int col = 3 * (y / 3) + (g % 3);

                if (tileBoard[row][col] == value || tileBoard[row][col] == 10 + value && row != x && col != y) {
                    System.out.println("problem z kratk¹");
                    return false;
                }
            }
            howManyBlanks--;
            System.out.println(howManyBlanks);
        }
            return true;

    }


    void editBoard(int key){
        if(key>=1 && key<=9){
            tileBoard[selectedX][selectedY] = 10 + key;
            if(!numCheck(selectedX, selectedY, key)){
                mistakes++;
            }

            selectedX = 10;
            selectedY = 10;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX() / gp.tileSize;
        int y = e.getY() / gp.tileSize;

        tileClicked(x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode()-48;
        editBoard(key);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


}

