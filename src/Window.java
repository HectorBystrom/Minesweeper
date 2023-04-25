import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    //Attributes

    //Constructor
    public Window() {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtFunc();

    }
    public void addButtFunc(){
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
        for (int i = 0; i <= 224; i++) {
            jPanel.add(new Square(this));

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
        for (int i = 0; i <= 63; i++) {
            jPanel.add(new Square(this));

        }
        this.getContentPane().add(jPanel);
        this.pack();
        this.setVisible(true);
    }

    //Getters and setters
}
