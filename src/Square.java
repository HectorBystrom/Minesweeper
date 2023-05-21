import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel implements MouseListener {
    //Attributes
    boolean isClicked = false;
    boolean isCovered = true;
    int x;
    int y;
    Window myWindow; //Create a new window


    //Constructor
    public Square(Window window, int x, int y) {
        myWindow = window;
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        this.setBackground(Color.black);
        this.x = x;
        this.y = y;
        window.setMyX(x);
        window.setMyY(y);


    }
    //Methods


    public void drawFlag(Graphics g) { //Draw the flag and flag amount
        g.setColor(Color.red);


        g.drawLine(50, 10, 50, 40);
        g.drawLine(50, 10, 30, 25);
        g.drawLine(30, 25, 50, 25);
        g.drawString("Flags: " + myWindow.getFlagAmount(), 80, 80);

    }

    private void drawNumber(Graphics g) { //Draw how many bombs there are nearby
        g.setColor(Color.magenta);
        g.setFont(g.getFont().deriveFont(50f));

        g.drawString(String.valueOf(getSurroundingMinesCount(myWindow)), 65, 60);
    }

    //Getters and setters
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!isClicked) {
                System.out.println(getSurroundingMinesCount(myWindow));
                drawNumber(getGraphics()); //If its not a bomb when u left click
                isCovered = false;
                isClicked = true;
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3) { //Draw flag and check flag amount
            if (this.isCovered) {
                if (this.isClicked) {

                    setBackground(Color.black);
                    this.isClicked = false;
                    myWindow.setFlagAmount(myWindow.getFlagAmount() + 1);
                    repaint();
                    System.out.println("Flag amount: " + myWindow.getFlagAmount());
                } else {
                    if (myWindow.getFlagAmount() > 0) {
                        drawFlag(getGraphics());
                        this.isClicked = true;
                        myWindow.setFlagAmount(myWindow.getFlagAmount() - 1);
                        System.out.println("Flag amount: " + myWindow.getFlagAmount());

                    }
                }
            }
        }
    }

    public int getSurroundingMinesCount(Window window) { //Check how many bombs there are nearby every safe square
        int surroundingMineCount = 0;
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                boolean isBomb = window.isBombAt(x + offsetX, y + offsetY);
                if (!isBomb) {
                    continue;
                }

                surroundingMineCount++;
            }
        }

        return surroundingMineCount;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
