import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Automaton {
    Logger applicationLogger = Logger.getLogger(StateApplication.class.getName());
    StateApplication getNextState(String strCharacter);

    public boolean isFinalState(StateApplication other);
    public boolean isFirstState(StateApplication other);
}
