import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    //Attributes
    int myX = 1;
    int myY = 1;

    Square[][] squares;

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
        Bomb bomb = new Bomb(this, myX, myY);
        GridLayout layout = new GridLayout(15, 15);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {

                if (bomb.isMine) {
                    jPanel.add(new Bomb(this, i, j));
                } else {
                    jPanel.add(new Square(this, i, j));
                }
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
        squares = new Square[8][8];

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                boolean shouldBeBomb = false;
                double x = Math.random();
                int z = (int) (x * 100);
                if (z < 30) {
                    shouldBeBomb = true;
                }

                Square newBomb;
                if (shouldBeBomb) {
                    newBomb = new Bomb(this, i, j);
                } else {
                    newBomb = new Square(this, i, j);
                }
                squares[i - 1][j - 1] = newBomb;
                jPanel.add(newBomb);
            }
        }

        this.getContentPane().add(jPanel);
        this.pack();
        this.setVisible(true);
    }
    public Square[][] getSquares() {
        return squares;
    }

    public boolean isBombAt(int x, int y) {
        boolean isBomb = false;
        Square[][] squares = this.getSquares();


        try {
            Square square = squares[x - 1][y - 1];


            isBomb = square instanceof Bomb;
        } catch (Exception ignored) {
        }
        return isBomb;
    }

    //Getters and setters

    public void setMyX(int myX) {
        this.myX = myX;
    }

    public void setMyY(int myY) {
        this.myY = myY;
    }
}