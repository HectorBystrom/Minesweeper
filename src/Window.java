import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //Attributes

    //Constructor
    public Window(){
this.setTitle("Minesweeper");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel jPanel = new JPanel();
GridLayout layout = new GridLayout(2,2);
jPanel.setLayout(layout);
jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));

jPanel.add(new Board(this));
    }
    //Methods

    //Getters and setters
}
