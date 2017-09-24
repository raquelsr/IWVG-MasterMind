package controllers_local;

import models.Combination;
import models.Game;
import models.State;

public abstract class LocalController {

    private Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    public Game getGame() {
        return this.game;
    }

    public void start(Combination combination) {
        game.start(combination);
    }

    protected void put(Combination combination) {
        assert combination != null;
        game.put(combination);
    }

    public int getDead() {
        return game.getDead();
    }

    public int getInjured() {
        return game.getInjured();
    }

    public int getAttempts() {
        return game.getAttempts();
    }

    public void addAttempt() {
        game.addAttempt();
    }

    public boolean win() {
        return game.win();
    }

    public boolean finish() {
        return game.finish();
    }

    public boolean finishCounter() {
        return game.finishCounter();
    }

}
