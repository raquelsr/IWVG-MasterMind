package controllers_local;

import controllers.CombinationControllerVisitor;
import controllers.UserCombinationController;
import models.Board;
import models.Color;
import models.Combination;
import models.Game;
import utils.LimitedCombinationDialog;

public class LocalUserCombinationController extends LocalCombinationController implements UserCombinationController {

    public LocalUserCombinationController(Game game) {
        super(game);
    }

    @Override
    public Combination getCombination() {
        char[] aux = new LimitedCombinationDialog(Color.values(), Board.DIMENSION).read().toCharArray();
        Combination combination = new Combination(Board.DIMENSION, aux);
        return combination;
    }

    @Override
    public void accept(CombinationControllerVisitor combinationControllerVisitor) {
        combinationControllerVisitor.visit(this);
    }

}
