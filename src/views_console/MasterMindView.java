package views_console;

import controllers.ContinueController;
import controllers.OperationController;
import controllers.OperationControllerVisitor;
import controllers.PutController;
import controllers.StartController;

public class MasterMindView implements OperationControllerVisitor {

    private StartView startView;

    private PutView putView;

    private ContinueView continueView;

    public MasterMindView() {
        startView = new StartView();
        putView = new PutView();
        continueView = new ContinueView();
    }

    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override
    public void visit(ContinueController continueController) {
        continueView.interact(continueController);
    }

    @Override
    public void visit(PutController putController) {
        putView.interact(putController);

    }
}
