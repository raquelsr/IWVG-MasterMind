package mastermind;

import controllers.OperationController;
import controllers_local.LocalLogic;
import views_console.ConsoleView;

public class MasterMind {

    private Logic logic;

    private View view;

    public MasterMind(Logic logic, View view) {
        this.logic = logic;
        this.view = view;
    }

    public void play() {
        OperationController controller;
        do {
            controller = logic.getOperationController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new MasterMind(new LocalLogic(), new ConsoleView()).play();
    }
}
