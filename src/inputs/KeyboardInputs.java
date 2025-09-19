package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-10, -100);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(10, 100);
                break;
            case KeyEvent.VK_W:
                System.out.println("It's W");
                break;
            case KeyEvent.VK_S:
                System.out.println("It's S");
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.jump();

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
