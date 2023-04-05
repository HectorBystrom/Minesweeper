import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //Attributes

    //Constructor
    public Window(){
this.setTitle("Minesweeper");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel jPanel = new JPanel();
GridLayout layout = new GridLayout(3,3);
jPanel.setLayout(layout);
jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));

for (int i = 0; i<=8; i++) {
    jPanel.add(new Square(this));
}
this.getContentPane().add(jPanel);
this.pack();
this.setVisible(true);
    }
    //Methods

    //Getters and setters
}
