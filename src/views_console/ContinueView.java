package views_console;

import controllers.ContinueController;
import utils.YesNoDialog;

public class ContinueView {

    public void interact(ContinueController continueController) {
        continueController.setContinue(new YesNoDialog("¿Desea continuar jugando").read());
    }
}
