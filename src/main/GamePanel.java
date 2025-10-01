package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel {
    private float xDelta = 400, yDelta = 200;
    private float xDir = 0.1f, yDir = 0.1f;
    private int frames = 0;
    private Color color = new Color(200,0,0);
    private Random random = new Random();
    public int randomNumber;
    private long lastCheck = 0;
    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
    }


    public void changeXDelta(int value, int border){
        if(this.xDelta + value == border){
            this.xDelta = this.xDelta;
        }else{
            this.xDelta += value;
        }

    }
    public void changeYDelta(int value, int border){
        if(this.yDelta + value == border){
            this.yDelta = this.yDelta;
        }
            else{
                this.yDelta += value;

            }


        }
        public void paintComponent(Graphics g){
        // calling super class paintComponent method
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect((int)xDelta, (int)yDelta, 50, 200);
        updateRectangle(g);
    }

    private void updateRectangle(Graphics g) {
        xDelta -= xDir;
        if(xDelta < -50 ){
            xDelta = 400;

            yDelta = random.nextInt(100, 400);
            g.fillRect((int )xDelta,(int) yDelta, 50, 200);
            color = generateRandomColor();
            randomNumber = random.nextInt(50,55);


            System.out.println("Random number for this iteration is: " + randomNumber);
            System.out.println("Color = " + color);


        }

    }
    private Color generateRandomColor(){
        int r = 0;
        int g = 0;
        int b = 0;
        r = random.nextInt(255);
        g = random.nextInt(255);
        b = random.nextInt(255);
        return new Color(r,g ,b);
    }
}


