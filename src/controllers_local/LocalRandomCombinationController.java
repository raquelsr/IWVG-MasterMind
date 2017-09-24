package controllers_local;

import controllers.CombinationControllerVisitor;
import controllers.RandomCombinationController;
import models.Combination;
import models.Game;

public class LocalRandomCombinationController extends LocalCombinationController implements RandomCombinationController {

    public LocalRandomCombinationController(Game game) {
        super(game);
    }

    @Override
    public Combination getCombination() {
        Combination combination = new Combination();
        combination.random();
        return combination;
    }

    @Override
    public void accept(CombinationControllerVisitor combinationControllerVisitor) {
        combinationControllerVisitor.visit(this);
    }
}
