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
        int x1 = 0, y1 = 0, y2 = 0, x3 = 0, y3 = 0, xx = 0, yy = 0;
        if (myWindow.hardMode) {
            x1 = 10;
            y1 = 10;
            y2 = 40;
            x3 = 30;
            y3 = 25;
            xx = 30;
            yy = 40;

        } else if (myWindow.easyMode) {
            x1 = 75;
            y1 = 10;
            y2 = 65;
            x3 = 30;
            y3 = 40;
            xx = 80;
            yy = 80;
        }
        g.drawLine(x1, y1, x1, y2);
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x3, y3, x1, y3);
        g.drawString("Flags: " + myWindow.getFlagAmount(), xx, yy);
    }

    private void drawNumber(Graphics g) { //Draw how many bombs there are nearby
        g.setColor(Color.magenta);
        g.setFont(g.getFont().deriveFont(30f));
        int k = 0, l = 0;
        if (myWindow.easyMode) {
            k = 72;
            l = 52;
        } else if (myWindow.hardMode) {
            k = 32;
            l = 32;
        }
        g.drawString(String.valueOf(getSurroundingMinesCount(myWindow)), k, l);

    }

    //Getters and setters
    @Override
    public void mouseClicked(MouseEvent e) {
        win();
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!isClicked) {
                System.out.println(getSurroundingMinesCount(myWindow));
                drawNumber(getGraphics()); //If it is not a bomb when u left click
                isCovered = false;
                isClicked = true;
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3) { //Draw flag and check flag amount
            flag();
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

    public void win() {
        if (myWindow.getFlagAmount() == 0) {
            System.out.println("You won! ");
            myWindow.dispose();
            new Window();
        }
    }
    public void flag() {
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

