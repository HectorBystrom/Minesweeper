import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    //Attributes
    int myX = 1;
    int myY = 1;

    //Constructor
    public Window() {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtFunc();

    }

    public void addButtFunc() {
        JPanel jPanel = new JPanel();

        JButton button1 = new JButton("Difficult");
        JButton button2 = new JButton("Easy");
        jPanel.add(button1);
        jPanel.add(button2);

        this.getContentPane().add(jPanel);
        this.pack();
        this.setVisible(true);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    //Methods

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Difficult")) {
            difficult();
        } else if (e.getActionCommand().equals("Easy")) {
            easy();
        }
    }

    public void difficult() {
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(15, 15);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                jPanel.add(new Square(this, i, j));
            }
        }
            this.getContentPane().add(jPanel);
            this.pack();
            this.setVisible(true);

        }


    public void easy() {
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(8, 8);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                jPanel.add(new Square(this, i, j));
            }
        }
        this.getContentPane().add(jPanel);
        this.pack();
        this.setVisible(true);
    }


    //Getters and setters

    public void setMyX(int myX) {
        this.myX = myX;
    }

    public void setMyY(int myY) {
        this.myY = myY;
    }
}
