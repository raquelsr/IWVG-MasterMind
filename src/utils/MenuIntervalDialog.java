package utils;

public class MenuIntervalDialog {

    private int min;

    private int max;

    public MenuIntervalDialog(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public MenuIntervalDialog(int max) {
        this(1, max);
    }

    public int read() {
        IO io = new IO();
        int value;
        boolean ok;
        do {
            value = io.readInt();
            ok = min <= value && value <= max;
            if (!ok) {
                io.writeln("El valor debe estar entre " + min + " y " + max);
            }
        } while (!ok);
        return value;
    }
}
