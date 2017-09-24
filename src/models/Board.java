package models;

public class Board {

    private Combination combinationSecret;

    private Combination combinationKey;

    private Combination combinationSecretAux;

    private Combination combinationKeyAux;

    public static final int ATTEMPTS = 10;

    public static final int DIMENSION = 4;

    public static final char MARK = 'X';

    private Counter counter;

    public Board() {
        this.counter = new Counter();
        this.combinationKey = new Combination();
        this.combinationSecret = new Combination();
    }

    public void start(Combination combination) {
        assert combination != null;
        this.combinationSecret = combination;
        this.combinationSecretAux = this.combinationSecret.copy();
        counter.reset();
    }

    public void put(Combination combination) {
        assert combination != null;
        this.combinationKey = combination;
        this.combinationKeyAux = this.combinationKey.copy();
    }

    public boolean win() {
        return this.combinationKey.equals(this.combinationSecret);
    }

    public int getDead() {
        int nDead = 0;
        for (int i = 0; i < Board.DIMENSION; i++) {
            if ((combinationKey.getToken()[i] == combinationSecret.getToken()[i]) && (combinationKeyAux.getToken()[i] != MARK)) {
                this.combinationKeyAux.getToken()[i] = MARK;
                this.combinationSecretAux.getToken()[i] = MARK;
                nDead++;
            }
        }
        return nDead;
    }

    public int getInjured() {
        int nInjured = 0;
        for (int i = 0; i < Board.DIMENSION; i++) {
            if (this.combinationKey.getToken()[i] != this.combinationSecret.getToken()[i]) {
                for (int j = 0; j < Board.DIMENSION; j++) {
                    if ((this.combinationSecretAux.getToken()[i] != MARK)
                            && (this.combinationSecretAux.getToken()[i] == this.combinationKeyAux.getToken()[j])) {
                        this.combinationKeyAux.getToken()[j] = MARK;
                        this.combinationSecretAux.getToken()[i] = MARK;
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
        if (this.win() || counter.finish()) {
            return true;
        }
        return false;
    }
}
