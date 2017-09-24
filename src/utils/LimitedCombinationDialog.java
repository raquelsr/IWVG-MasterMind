package utils;

import controllers.Error;
import models.Color;

public class LimitedCombinationDialog {

    private ClosedLength length;

    public LimitedCombinationDialog(Color[] parametros, int dimension) {
        this.length = new ClosedLength(dimension);
    }

    public String read() {
        IO io = new IO();
        String value;
        boolean ok;
        do {
            value = io.readString();
            value = value.toUpperCase();
            ok = length.correctLength(value.length());
            if (!ok) {
                io.writeln(Error.NOT_DIMENSION.toString() + this.length + " \nPruebe de nuevo:");
            } else {
                ok = this.validate(value);
            }
        } while (!ok);
        return value;
    }

    public boolean validate(String combination) {
        IO io = new IO();
        boolean ok = true;
        String colors = "";
        for (int i = 0; i < Color.values().length; i++) {
            colors = colors.concat(String.valueOf(Color.values()[i]));
        }

        for (int i = 0; i < combination.length(); i++) {
            if (!colors.contains(String.valueOf(combination.charAt(i)))) {
                ok = false;
                break;
            }
        }
        if (!ok) {
            io.writeln(Error.NOT_COLOR + colors + " .\nPruebe de nuevo:");
        }
        return ok;
    }
}
