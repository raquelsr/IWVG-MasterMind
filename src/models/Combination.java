package models;

import java.util.Random;

import utils.LimitedCombinationDialog;

public class Combination {

    private static final int LENGTH = 4;

    private utils.Combination combination;

    public Combination() {
        this.combination = new utils.Combination(LENGTH);
    }

    public Combination(int length, char[] token) {
        this.combination = new utils.Combination(LENGTH);
        combination.setToken(token.clone());
    }

    public void read() {
        System.out.println(Color.values());
        combination.setToken(new LimitedCombinationDialog(Color.values(), LENGTH).read().toCharArray());
    }

    public String toString(char[] combination) {
        assert combination != null;
        return String.valueOf(combination);
    }

    public boolean equals(Combination c) {
        assert c != null;
        for (int i = 0; i < LENGTH; i++) {
            if (combination.getToken()[i] != c.getToken()[i]) {
                return false;
            }
        }
        return true;
    }

    public Combination copy() {
        return new Combination(LENGTH, combination.getToken());
    }

    public void random() {
        Random random = new Random();
        String colors = "";
        for (int i = 0; i < Color.values().length; i++) {
            colors = colors.concat(String.valueOf(Color.values()[i]));
        }
        char[] randomToken = {'_', '_', '_', '_'};
        for (int i = 0; i < LENGTH; i++) {
            randomToken[i] = colors.charAt(random.nextInt(colors.length()));
        }
        combination.setToken(randomToken);
    }

    public char[] getToken() {
        return combination.getToken();
    }
}
