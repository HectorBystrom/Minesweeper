import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    //Attributes
    int myX = 1;
    int myY = 1;
    int flagAmount = 0;
    boolean hardMode = false;
    boolean easyMode = false;
    Square[][] squares;

    //Constructor
    public Window() {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtFunc();
    }

    //Methods
    //To create 2 buttons from difficult and easy and add, so they work.
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

    //Method that explains what the buttons are going to do
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Difficult")) {
            difficult();
        } else if (e.getActionCommand().equals("Easy")) {
            easy();
        }
    }

    //Method that explains everything in the difficult version of the game.
    public void difficult() {
        hardMode = true;
        panelMaker(15);
    }


    public void easy() {
        easyMode = true;
        panelMaker(8);
    }

    public Square[][] getSquares() { //getter for square
        return squares;
    }

    public boolean isBombAt(int x, int y) { //Method to check if it is a bomb or not
        boolean isBomb = false;
        Square[][] squares = this.getSquares();
        try {
            Square square = squares[x - 1][y - 1]; //Finds the square at these x and y coordinates
            isBomb = square instanceof Bomb; //Checking instances of bomb
        } catch (Exception ignored) {
        }
        return isBomb;
    }

    public void panelMaker(int a) {
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(a, a);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        squares = new Square[a][a];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                boolean shouldBeBomb = false;
                double x = Math.random();
                int z = (int) (x * 100);
                if (z < 30) {
                    shouldBeBomb = true;
                    flagAmount++;
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
    //Getters and setters

    public void setMyX(int myX) {
        this.myX = myX;
    }

    public void setMyY(int myY) {
        this.myY = myY;
    }

    public int getFlagAmount() {
        return flagAmount;
    }

    public void setFlagAmount(int flagAmount) {
        this.flagAmount = flagAmount;
    }
}