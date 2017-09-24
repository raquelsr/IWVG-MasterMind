package controllers_local;

import controllers.ContinueController;
import controllers.OperationControllerVisitor;
import models.Game;
import models.State;

public class LocalContinueController extends LocalOperationController implements ContinueController {

    protected LocalContinueController(Game game) {
        super(game);
    }

    public void setContinue(boolean another) {
        assert this.getState() == State.FINAL;
        if (another) {
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
