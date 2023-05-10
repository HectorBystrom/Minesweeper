import java.util.ArrayList;

public class Bomb extends Square {
    //Attributes
    boolean isMine;

    ArrayList<Integer> cordsX = new ArrayList<>();
    ArrayList<Integer> cordsY = new ArrayList<>();

    //Constructor
    public Bomb(Window window) {
        super(window, window.myX, window.myY);
        mine();

        checkMine();

    }

    public void mine() {
        double x = Math.random();
        int z = (int) (x * 100);
        if (z < 30) {
            this.isMine = true;
        }
        if (z > 30) {
            this.isMine = false;
        }

    }
    //Methods
    public void checkMine() {
        cordsX.add(x);
        cordsY.add(y);
        if(!isMine){
            System.out.println("test");
        }
    }
    //Getters and setters
}
