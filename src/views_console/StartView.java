package views_console;

import controllers.StartController;
import utils.IO;
import utils.MenuIntervalDialog;

public class StartView {

    void interact(StartController startController) {
        IO io = new IO();
        io.writeln("¡BIENVENIDO A MASTERMIND!");
        io.writeln("Elige modo de juego:");
        io.writeln(" 1 - Demo");
        io.writeln(" 2 - Jugar");
        int option = new MenuIntervalDialog(2).read();
        startController.start(option);
        new BoardView(startController).write();
    }

}
