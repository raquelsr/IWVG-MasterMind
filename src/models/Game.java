package models;

public class Game {

    private State state;

    private Board board;

    public Game() {
        state = State.INITIAL;
        board = new Board();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void put(Combination combination) {
        this.board.put(combination);
    }

    public boolean win() {
        return this.board.win();
    }

    public int getDead() {
        return this.board.getDead();
    }

    public int getInjured() {
        return this.board.getInjured();
    }

    public boolean finish() {
        return board.finish();
    }

    public void start(Combination combination) {
        board.start(combination);
    }

    public int getAttempts() {
        return board.getAttempts();
    }

    public void addAttempt() {
        board.addAttempt();
    }

    public boolean finishCounter() {
        return board.finishCounter();
    }
}
