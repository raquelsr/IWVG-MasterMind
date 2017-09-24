package utils;

public class Combination {

    private char[] token;

    private int length;

    public Combination() {

    }

    public Combination(int length) {
        this.length = length;
    }

    public Combination(int length, char[] token) {
        this.length = length;
        this.token = token.clone();
    }

    public String toString(char[] combination) {
        assert combination != null;
        return String.valueOf(combination);
    }

    public char[] getToken() {
        return token;
    }

    public void setToken(char[] token) {
        this.token = token;
    }

    public int getDimension() {
        return length;
    }

    public void setDimension(int dimension) {
        this.length = dimension;
    }

}
