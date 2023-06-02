package CodeBreaker;

import java.util.*;

public class Generator {
    private final Random random;

    public Generator(){
        this.random = new Random();
    }

    public Generator(Random random){
        this.random = random;
    }

    public String generateCode() {
        List<Integer> list = new ArrayList<>();
        while (list.size() < 4) {
            list.add(this.random.nextInt(4) + 1);
        }
        String s = list.toString().replace(", ", "");
        return s.replaceAll("^\\[|]", "");
    }

}
