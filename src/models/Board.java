package models;

public class Board {

    private Combination secretCombination;

    private Combination publicCombination;

    private Combination secretCombinationAux;

    private Combination publicCombinationAux;

    public static final int ATTEMPTS = 10;

    public static final int DIMENSION = 4;

    public static final char MARK = 'X';

    private Counter counter;

    public Board() {
        this.counter = new Counter();
        this.publicCombination = new Combination();
        this.secretCombination = new Combination();
    }

    public void start(Combination combination) {
        assert combination != null;
        this.secretCombination = combination;
        this.secretCombinationAux = this.secretCombination.copy();
        counter.reset();
    }

    public void put(Combination combination) {
        assert combination != null;
        this.publicCombination = combination;
        this.publicCombinationAux = this.publicCombination.copy();
    }

    public boolean win() {
        return this.publicCombination.equals(this.secretCombination);
    }

    public int getDead() {
        int nDead = 0;
        for (int i = 0; i < Board.DIMENSION; i++) {
            if ((publicCombination.getToken()[i] == secretCombination.getToken()[i]) && (publicCombinationAux.getToken()[i] != MARK)) {
                this.publicCombinationAux.getToken()[i] = MARK;
                this.secretCombinationAux.getToken()[i] = MARK;
                nDead++;
            }
        }
        return nDead;
    }

    public int getInjured() {
        int nInjured = 0;
        for (int i = 0; i < Board.DIMENSION; i++) {
            if (this.publicCombination.getToken()[i] != this.secretCombination.getToken()[i]) {
                for (int j = 0; j < Board.DIMENSION; j++) {
                    if ((this.secretCombinationAux.getToken()[i] != MARK)
                            && (this.secretCombinationAux.getToken()[i] == this.publicCombinationAux.getToken()[j])) {
                        this.publicCombinationAux.getToken()[j] = MARK;
                        this.secretCombinationAux.getToken()[i] = MARK;
                        nInjured++;
                    }
                }
            }
        }
        return nInjured;
    }

    public int getAttempts() {
        return counter.getAttempts();
    }

    public void addAttempt() {
        counter.add();
    }

    public boolean finishCounter() {
        return counter.finish();
    }

    public boolean finish() {
        if (this.win() || this.finishCounter()) {
            return true;
        }
        return false;
    }
}
