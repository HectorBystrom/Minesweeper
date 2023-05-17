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
    Window myWindow;


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


    public void drawFlag(Graphics g) {
        g.setColor(Color.red);


        g.drawLine(50, 10, 50, 40);
        g.drawLine(50, 10, 30, 25);
        g.drawLine(30, 25, 50, 25);


    }

    //Getters and setters
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(getSurroundingMinesCount(myWindow));

        this.setBackground(Color.green);
        isCovered = false;
        isClicked = true;
        repaint();

        if (e.getButton() == MouseEvent.BUTTON3) {
            if (this.isCovered) {
                if (this.isClicked) {

                    setBackground(Color.black);
                    this.isClicked = false;
                    repaint();
                } else {
                    drawFlag(getGraphics());
                    this.isClicked = true;
                }
            }
        }
    }

    public int getSurroundingMinesCount(Window window) {
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