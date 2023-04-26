import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel implements MouseListener {
    //Attributes
    boolean isClicked = false;
    boolean isCovered = true;
    Window myWindow;

    //Constructor
    public Square(Window window) {
        myWindow = window;
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        this.setBackground(Color.black);

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
        Bomb bomb = new Bomb(myWindow);
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!bomb.isMine) {
                this.setBackground(Color.green);
                isCovered = false;
                repaint();
            } else {
                this.setBackground(Color.red);
                repaint();
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            if (this.isCovered) {
                if (this.isClicked) {
                    setBackground(Color.black);
                    this.isClicked = false;
                    repaint();
                }
                else{
                    drawFlag(getGraphics());
                    this.isClicked = true;
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
