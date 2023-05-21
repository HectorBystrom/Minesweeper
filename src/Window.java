import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    //Attributes
    int myX = 1;
    int myY = 1;
    int flagAmount = 0;
    Square[][] squares;

    //Constructor
    public Window() {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButtFunc();
    }
    //Methods
    //To create 2 buttons from difficult and easy and add so they work.
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
    //Method that explains what the buttons are gonna do
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Difficult")) {
            difficult();
        } else if (e.getActionCommand().equals("Easy")) {
            easy();
        }
    }

    //Method that explains everything in the difficult version of the game.
    public void difficult() {
        JPanel jPanel = new JPanel();
        GridLayout layout = new GridLayout(15, 15);
        jPanel.setLayout(layout);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        //Create 2D array to list x and y in order to count nearby bombs.
        squares = new Square[15][15];
        //Create 15x15 board
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                boolean shouldBeBomb = false; //Checks if theres a bomb in order to create the board knowingly where the bombs are
                double x = Math.random();
                int z = (int) (x * 100);
                if (z < 30) { //30% bombs.
                    shouldBeBomb = true;
                    flagAmount++;
                }

                Square newBomb;
                if (shouldBeBomb) {
                    newBomb = new Bomb(this, i, j); //Create the bombs
                } else {
                    newBomb = new Square(this, i, j); //Create the squares

                }
                squares[i - 1][j - 1] = newBomb; //Change the 2D array to look for bombs around
                jPanel.add(newBomb);
            }
        }

        this.getContentPane().add(jPanel); //Create the board
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

    public Square[][] getSquares() { //getter for square
        return squares;
    }

    public boolean isBombAt(int x, int y) { //Method to check if its a bomb or not
        boolean isBomb = false;
        Square[][] squares = this.getSquares();


        try {
            Square square = squares[x - 1][y - 1];


            isBomb = square instanceof Bomb; //Checking instances of bomb
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

    public int getFlagAmount() {
        return flagAmount;
    }

    public void setFlagAmount(int flagAmount) {
        this.flagAmount = flagAmount;
    }



}