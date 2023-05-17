import java.awt.*;
import java.awt.event.MouseEvent;

public class Bomb extends Square {
    // Attributes
    boolean isMine;


    // Constructor
    public Bomb(Window window, int x, int y) {
        super(window, window.myX, window.myY);

        this.x = x;
        this.y = y;
    }


    // Methods

    @Override
    public void mouseClicked(MouseEvent e) {


        this.setBackground(Color.red);
        isCovered = false;
        isClicked = true;
        repaint();

    }


    // Getters and setters

}