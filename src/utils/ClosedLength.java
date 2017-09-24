package utils;

public class ClosedLength {

    private int length;

    public ClosedLength(int length) {
        this.length = length;
    }

    public boolean correctLength(int value) {
        assert value > 0;
        return this.length == value;
    }

    @Override
    public String toString() {
        return "Longitud: " + length;
    }
}
