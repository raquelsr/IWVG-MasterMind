package controllers_local;

import controllers.OperationControllerVisitor;
import controllers.PutController;
import models.Combination;
import models.Game;
import models.State;

public class LocalPutController extends LocalOperationController implements PutController {

    private LocalCombinationController combinationController;

    public LocalPutController(Game game, LocalCombinationController combinationController) {
        super(game);
        assert combinationController != null;
        this.combinationController = combinationController;
    }

    public void put(Combination combination) {
        this.getGame().put(combination);
    }

    public boolean finish() {
        if (this.getGame().finish()) {
            this.setState(State.FINAL);
        }
        return this.getGame().finish();
    }

    public LocalCombinationController getCombinationController() {
        return combinationController;
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
