package controllers_local;

import controllers.OperationControllerVisitor;

import controllers.StartController;
import models.Combination;
import models.Game;
import models.State;

public class LocalStartController extends LocalOperationController implements StartController {

    LocalCombinationControllerBuilder combinationControllerBuilder;

    protected LocalStartController(Game game, LocalCombinationControllerBuilder combinationControllerBuilder) {
        super(game);
        this.combinationControllerBuilder = combinationControllerBuilder;
    }

    public void start(int option) {
        assert option > 0;
        assert this.getState() == State.INITIAL;
        this.combinationControllerBuilder.build(option - 1);
        Combination random = new LocalRandomCombinationController(this.getGame()).getCombination();
        this.start(random);
        this.setState(State.IN_GAME);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
