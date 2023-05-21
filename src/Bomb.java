import java.awt.*;
import java.awt.event.MouseEvent;
//import java.awt.event.WindowEvent;

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
            if (this.isCovered) {
                if (this.isClicked) {

                    setBackground(Color.black);
                    myWindow.setFlagAmount(myWindow.getFlagAmount() + 1);
                    this.isClicked = false;
                    repaint();
                    System.out.println("Flag amount: " + myWindow.getFlagAmount());
                } else {
                    drawFlag(getGraphics());
                    this.isClicked = true;
                    myWindow.setFlagAmount(myWindow.getFlagAmount() - 1);
                    System.out.println("Flag amount: " + myWindow.getFlagAmount());
                }
            }
        }
    }

    public void loose() { // exit when u loose or restart
        System.out.println("you have lost! ");
      //  WindowEvent closeWindow = new WindowEvent(myWindow,WindowEvent.WINDOW_CLOSING);
       // Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
        myWindow.dispose();
        new Window();
    }

    // Getters and setters


}