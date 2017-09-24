package controllers;

import models.Combination;

public interface UserCombinationController extends CombinationController {

    @Override
    public Combination getCombination();

}
