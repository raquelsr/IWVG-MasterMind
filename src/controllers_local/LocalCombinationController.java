package controllers_local;

import controllers.CombinationController;
import controllers.CombinationControllerVisitor;
import models.Combination;
import models.Game;

public abstract class LocalCombinationController extends LocalController implements CombinationController {

    protected LocalCombinationController(Game game) {
        super(game);
    }

    public abstract Combination getCombination();

    public abstract void accept(CombinationControllerVisitor combinationControllerVisitor);

}
