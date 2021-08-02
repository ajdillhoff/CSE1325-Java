public class Player {
    private String name;
    private int x;
    private int y;
    private int totalMovement = 5;
    private int currentMovement = 5;

    public Player(String name) {
        this.name = name;
        x = 0;
        y = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getCurrentMovement() {
        return this.currentMovement;
    }

    public void setCurrentMovement(int movement) {
        this.currentMovement = movement;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;

        System.out.printf("%s moved to (%d, %d)\n", this.name, x, y);
    }
}
