package CodeBreaker;

public class CodeBreaker {
    private final String code;
    private final Player player;


    public CodeBreaker(Generator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public CodeBreaker(){
        this(new Generator(), new Player());

    }

    public void runGame(){
        System.out.print("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it."+"\n");
        while (true) {
            String guess = player.getGuess();
            int correct_digits_and_position = 0;
            int correct_digits_only = 0;

            if (guess.equals("exit")||guess.equals("quit")) {
                System.out.println("Shutting down..");
                break;
            }

            for (int i = 0; i < 4 ; i++) {
                if (code.charAt(i) == guess.charAt(i)) {
                    correct_digits_and_position++;
                } else if (code.contains("" + guess.charAt(i))) {
                    correct_digits_only++;
                }
            }
            System.out.println("Number of correct digits in correct place: "+correct_digits_and_position);
            System.out.println("Number of correct digits not in correct place: "+correct_digits_only);

            if (guess.equals(code)) {
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: " +code);
                break;
            }
            else if (player.getTurns() == 1) {
                System.out.println("No more turns left.");
                System.out.println("The code was: " +code);
                break;
            }
            else {
                player.lostChance();
                System.out.println("Turns left: " + player.getTurns());
            }
        }


    }

    public static void main(String[] args){
        CodeBreaker game = new CodeBreaker();
        game.runGame();
    }
}
