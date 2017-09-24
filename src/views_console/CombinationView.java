package views_console;

import models.Combination;
import utils.IO;

public class CombinationView {

    private Combination combination;

    private IO io;

    public CombinationView(Combination combination) {
        assert combination != null;
        this.combination = combination;
        io = new IO();
    }

    public void read() {
        combination.read();
    }

    public void write() {
        for (int i = 0; i < combination.getToken().length; i++) {
            io.write(String.valueOf(combination.getToken()[i]));
        }
    }

    void winner() {
        io.writeln("¡ENHORABUENA! ¡Has ganado la partida!");
    }
}
