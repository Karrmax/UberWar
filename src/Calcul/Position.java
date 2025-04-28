package Calcul;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // === Getters ===
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // === Setters ===
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
