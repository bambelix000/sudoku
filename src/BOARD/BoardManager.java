package BOARD;

import MAIN.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.Random;

import static javax.imageio.ImageIO.read;

public class BoardManager extends MouseAdapter {

    GamePanel gp;
    Number[] number;
    int[][] tileBoard;


    public BoardManager(GamePanel gp, int maxBoardNum) {
        this.gp = gp;
        number = new Number[100];
        int randomNum = randomNumber(maxBoardNum);
        getNumber();
        tileBoard = new int[gp.boardWidth][gp.boardHeight];
        loadBoard("/BOARDS/board0" + randomNum + ".txt");
        createGameBoard(randomNum);
    }
     int randomNumber(int max){
        Random rand = new Random();
        int random = rand.nextInt(max);;
        return  random + 1;
    }

    public void createGameBoard(int num) {
        try {
            Files.copy(Path.of("res/BOARDS/board0" + num + ".txt"), Path.of("res/BOARDS/game.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void editBoard(int x, int y){
        try {
            String filepath = "/BOARDS/game.txt";


        }catch(Exception e){

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

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX() / gp.tileSize;
        int y = e.getY() / gp.tileSize;

        editBoard(x+1, y+1);
        System.out.println(x + " "+ y);

    }



}

