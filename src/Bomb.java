import java.awt.*;
import java.awt.event.MouseEvent;

public class Bomb extends Square {
    // Attributes
    boolean looser = false;
    // Constructor
    public Bomb(Window window, int x, int y) {
        super(window, window.myX, window.myY);

        this.x = x;
        this.y = y;
    }

    // Methods
    @Override
    public void mouseClicked(MouseEvent e) { //Creating the bombs when u click
        if (e.getButton() == MouseEvent.BUTTON1) {
            looser = true;
            this.setBackground(Color.red);
            isCovered = false;
            isClicked = true;
            repaint();
            loose();
        }
        if (e.getButton() == MouseEvent.BUTTON3) { //Draw the flag

            flag();
        }
    }

    public void loose() { // exit when u loose or restart
        System.out.println("you have lost! ");
        myWindow.dispose();
        new Window();
    }
    // Getters and setters
}