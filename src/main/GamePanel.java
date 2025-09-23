package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel {
    private int xDelta = 0, yDelta = 0;
    private int xDir = 1, yDir = 1;
    private int frames = 0;
    private Random random = new Random();
    private Color color = new Color(150,20,90);
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
        updateRectangle();
        g.setColor(setNewColor());



        g.fillRect(300+xDelta, 200 + yDelta,50,200);
        frames++;
        // checking out last timeframe
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames );
                frames = 0;

            }
        repaint();


    }

    private void updateRectangle() {
        xDelta -= 10;
    }

    private Color setNewColor() {
        int r = 0;
        int g = 0;
        int b = 0;
        r = random.nextInt(255);
        g = random.nextInt(255);
        b = random.nextInt(255);
        return new Color(r, g , b);

    }
}
