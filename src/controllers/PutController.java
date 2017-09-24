package controllers;

import models.Combination;

public interface PutController extends OperationController {

    public void put(Combination combination);

    public CombinationController getCombinationController();

    public int getDead();
    
    public int getInjured();
    
    public boolean finishCounter();

    public int getAttempts();

    public void addAttempt();
    
    public boolean win();

    public boolean finish();

}
