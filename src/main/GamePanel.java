package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {
    private int xDelta = 0, yDelta = 0;
    public GamePanel() {
        addKeyListener(new KeyboardInputs(this));
    }


    public void changeXDelta(int value, int border){
        if(this.xDelta + value == border){
            this.xDelta = this.xDelta;
        }else{
            this.xDelta += value;
        }


        repaint();

    }
    public void changeYDelta(int value){
        this.yDelta -= value;
        repaint();

    }
    public void jump(){
        int jumpValue = 20;
        for(int i=0; i < 20; i++){
            changeYDelta(jumpValue);
            jumpValue -= 5;

        }
    }

    public void paintComponent(Graphics g){
        // calling super class paintComponent method
        super.paintComponent(g);

        g.fillRect(100+xDelta, 200 + yDelta,200,50);


    }
}
