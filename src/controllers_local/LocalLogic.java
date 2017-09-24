package controllers_local;

import controllers.OperationController;
import mastermind.Logic;
import models.Game;

public class LocalLogic implements Logic {
    private Game game;

    private LocalStartController startController;

    private LocalContinueController continueController;

    private LocalCombinationControllerBuilder combinationControllerBuilder;

    public LocalLogic() {
        game = new Game();
        combinationControllerBuilder = new LocalCombinationControllerBuilder(game);
        startController = new LocalStartController(game, combinationControllerBuilder);
        continueController = new LocalContinueController(game);
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
        case INITIAL:
            return startController;
        case IN_GAME:
            return combinationControllerBuilder.getPutController();
        case FINAL:
            return continueController;
        case EXIT:
        default:
            return null;
        }
    }
}
