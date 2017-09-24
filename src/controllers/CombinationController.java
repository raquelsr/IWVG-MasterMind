package controllers;

import models.Combination;

public interface CombinationController {

    public abstract Combination getCombination();

    public abstract void accept(CombinationControllerVisitor combinationControllerVisitor);

}
