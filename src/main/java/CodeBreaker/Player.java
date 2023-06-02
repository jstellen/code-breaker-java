package CodeBreaker;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private final Scanner inputScanner;
    private boolean quit = false;
    private int turns = 12;

    public Player() {
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    public int getTurns() {
        return turns;
    }

    public boolean hasNoChances() {
        return this.getTurns() == 0;
    }

    public void lostChance() {
        if (!this.hasNoChances()) {
            this.turns--;
        }
    }

    public String getGuess() {
        System.out.println("Input 4 digit code:");
        String text = this.inputScanner.nextLine();
        this.quit = text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("exit");
        return valid(text);
    }

    public static boolean isDigit(String text) {
        try {
            Integer.parseInt(text);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public ArrayList array(String text) {
        String[] arraylist = text.split("");
        return new ArrayList<String>(Arrays.asList(arraylist));
    }

    public boolean range(String text) {
        ArrayList txt = array(text);
        for (Object o : txt) {
            int characters = Integer.parseInt((String) o);
            if (characters > 8 || characters < 1) {
                return false;
            }
        }
        return true;
    }

    public boolean wantsToQuit() {
        return this.quit;
    }

    public String valid(String text) {

        while  ((text.length() != 4) || !(isDigit(text)) || !(range(text))) {
            if (wantsToQuit()) {
                return text;
            }
            else {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
                text = getGuess();
            }
        }
        return text;
    }
}
