import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JPanel implements MouseListener {
    //Attributes
    Window myWindow;
    //Constructor
    public Square(Window window){
        myWindow = window;
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        this.setBackground(Color.black);

    }
    //Methods


public void drawFlag(Graphics g){
    g.setColor(Color.red);


    g.drawLine(50,10,50,40);
        g.drawLine(50,10,30,25);
        g.drawLine(30,25,50,25);

}
    //Getters and setters
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1){
            this.setBackground(Color.green);
            repaint();
        }
        else if(e.getButton()==MouseEvent.BUTTON3){
            drawFlag(getGraphics());
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
