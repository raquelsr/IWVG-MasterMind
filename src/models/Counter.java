package models;

public class Counter {

    private utils.Counter counter;

    public static final int ATTEMPTS = 10;

    public Counter() {
        this.counter = new utils.Counter();
    }

    public int getCounter() {
        return counter.getCounter();
    }

    public void add() {
        counter.add();
    }

    public boolean finish() {
        if (counter.getCounter() == ATTEMPTS) {
            return true;
        }
        return false;
    }

    public int getAttempts() {
        return ATTEMPTS - counter.getCounter();
    }

    public void reset() {
        counter.setCounter(1);
    }
}
