package controllers;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(ContinueController continueController);

    void visit(PutController putController);

}
