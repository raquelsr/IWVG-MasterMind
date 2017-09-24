package controllers;

public interface CombinationControllerVisitor {

    void visit(UserCombinationController userCombinationController);

    void visit(RandomCombinationController randomCombinationController);
}
