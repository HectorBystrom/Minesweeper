public class Bomb extends Square {
    //Attributes
    boolean isMine;

    //Constructor
    public Bomb(Window window) {
        super(window);
        mine();
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

    //Getters and setters
}
