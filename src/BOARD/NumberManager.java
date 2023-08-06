package BOARD;

import MAIN.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class NumberManager{

    GamePanel gp;
    Number[] number;
    int[][] tileBoard;

    public NumberManager(GamePanel gp){
        this.gp = gp;
        number = new Number[100];
        tileBoard = new int[gp.boardWidth][gp.boardHeight];
        loadBoard("/BOARDS/board0" + randomNumber(3) + ".txt");
        getNumber();
    }
     int randomNumber(int max){
        Random rand = new Random();
        int random = rand.nextInt(max);;
        return  random + 1;
    }

    public void getNumber(){
        try{
            number[0] = new Number();
            number[0].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/blank.png"));

            number[1] = new Number();
            number[1].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/1.png"));

            number[2] = new Number();
            number[2].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/2.png"));

            number[3] = new Number();
            number[3].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/3.png"));

            number[4] = new Number();
            number[4].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/4.png"));

            number[5] = new Number();
            number[5].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/5.png"));

            number[6] = new Number();
            number[6].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/6.png"));

            number[7] = new Number();
            number[7].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/7.png"));

            number[8] = new Number();
            number[8].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/8.png"));

            number[9] = new Number();
            number[9].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/9.png"));

            number[10] = new Number();
            number[10].image = ImageIO.read(getClass().getResourceAsStream("/NUMBERS/selected.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadBoard(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));

            int x = 0;
            int y = 0;

            while(x < 9 && y < 9){

                String line = br.readLine();

                while(x < 9){
                    String[] number = line.split(" ");

                    int num = Integer.parseInt(number[x]);

                    tileBoard[x] [y] = num;
                    x++;
                }
                if(x == 9){
                    x = 0;
                    y++;
                }
            }
            br.close();

        }catch(Exception e){

        }
    }

    public void drawNumber(Graphics2D g2){
        int boardWidth = 0;
        int boardHeight = 0;

        while(boardHeight < gp.boardHeight && boardWidth < gp.boardWidth){

            int num = tileBoard[boardWidth][boardHeight];

            int boardX = boardWidth * gp.tileSize;
            int boardY = boardHeight * gp.tileSize;

            if(num == 1){
                g2.drawImage(number[num].image, boardX + 25, boardY + 5 , gp.tileSize - 50, gp.tileSize - 10, null);
            }else{
                g2.drawImage(number[num].image, boardX + 7, boardY + 5, gp.tileSize - 15, gp.tileSize - 10, null);
            }


            boardWidth++;

            if(boardWidth == gp.boardWidth){
                boardWidth = 0;
                boardHeight++;
            }
        }
    }

}

