package utils;

public class YesNoDialog {

    private String title;

    public YesNoDialog(String title) {
        assert title != null;
        this.title = title;
    }

    public boolean read() {
        String answer;
        IO io = new IO();
        boolean ok;
        do {
            answer = io.readString(title + "? (S/N): ");
            ok = answer.equals("s") || answer.equals("S") || answer.equals("n") || answer.equals("N");
            if (!ok) {
                io.writeln("El valor debe ser 'S' ó 'N'");
            }
        } while (!ok);
        return answer.equals("s") || answer.equals("S");
    }
}
