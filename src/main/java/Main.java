import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new ABCAutomaton();

        new Thread(() -> {
            StateApplication stateApplication = automaton.getNextState("A");
            String alphabet = "ABCBCABCDA";
            System.out.println(stateApplication.getStateLevel());
            System.out.println(stateApplication.getCommands());

            for (int indexstr = 0; indexstr < alphabet.length() - 1; indexstr++) {
                char c = alphabet.charAt(indexstr);
                stateApplication = automaton.getNextState(String.valueOf(c));
                if (stateApplication == null) break;
                System.out.println(stateApplication.getStateLevel());
                System.out.println(stateApplication.getCommands());
            }
        }
        ).start();


    }
}
