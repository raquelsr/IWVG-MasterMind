package views_console;

import controllers.OperationController;
import utils.IO;

public class BoardView {

    public BoardView(OperationController controller) {
        assert controller != null;
    }

    void write() {
        IO io = new IO();
        io.writeln();
        io.write("CLAVE SECRETA GENERADA : ****");
    }

}
