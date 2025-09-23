package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GamePanel extends JPanel {
    private float xDelta = 400, yDelta = 200;
    private float xDir = 0.1f, yDir = 0.1f;
    private int frames = 0;
    private Random random = new Random();
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
        updateRectangle(g);
        g.setColor(Color.RED);




        g.fillRect((int) xDelta, (int) yDelta, 50, 200);
        frames++;
        // checking out last timeframe
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames );
                frames = 0;

            }
        repaint();


    }

    private void updateRectangle(Graphics g) {
        xDelta -= xDir;
        if(xDelta < 200 ){
            xDelta = 400;
            g.fillRect((int )xDelta,(int) yDelta, 50, 200);
        }
    }
}


