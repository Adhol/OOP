public class Route {
    private int lengthKm;
    private boolean isDone;

    public Route(int lengthKm) {
        this.lengthKm = lengthKm;
        this.isDone = false;
    }

    public int getLengthKm() {
        return lengthKm;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
