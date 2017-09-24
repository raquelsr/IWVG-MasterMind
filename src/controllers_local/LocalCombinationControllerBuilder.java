package controllers_local;

import models.Game;

public class LocalCombinationControllerBuilder {

    private LocalCombinationController combinationController;

    private Game game;

    public LocalCombinationControllerBuilder(Game game) {
        this.game = game;
    }

    public void build(int users) {
        if (users == 0) {
            combinationController = new LocalRandomCombinationController(game);
        }
        if (users == 1) {
            combinationController = new LocalUserCombinationController(game);
        }
    }

    public LocalPutController getPutController() {
        return new LocalPutController(game, combinationController);
    }
}
