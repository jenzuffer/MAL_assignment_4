import java.util.ArrayList;
import java.util.List;

public class ABCAutomaton implements Automaton {

    private List<StateApplication> getStates = new ArrayList<StateApplication>();
    private StateApplication stateApplicationFirst = new StateApplication("A", 0);
    private StateApplication stateApplicationFinal = new StateApplication("D", 2);
    private int currentLevel = 0;

    public ABCAutomaton() {
        getStates.add(stateApplicationFirst);
        StateApplication stateApplication = new StateApplication("B", 1);
        getStates.add(stateApplication);
        stateApplication = new StateApplication("C", 1);
        getStates.add(stateApplication);
        getStates.add(stateApplicationFinal);
    }

    public StateApplication getNextState(String strCharacter) {
        StateApplication stateApplicationfinal = null;

        if (strCharacter.equals("A")) {
            if (this.currentLevel != 0) {
                applicationLogger.severe("You are logged in and can therefore only process" +
                        "Command B and C and D");
                return null;
            }
        } else if (this.currentLevel == 0) {
            applicationLogger.severe("You are not logged in and can therefore only process " +
                    "Command A");
            return null;
        } else if (strCharacter.equals("D")) {
            applicationLogger.info("You logged out of the system");
            return null;
        }


        for (StateApplication stateApplicationitrr : getStates) {
            if (stateApplicationitrr.getCommands().equals(strCharacter)) {
                stateApplicationfinal = stateApplicationitrr;
                this.currentLevel = stateApplicationitrr.getStateLevel();
                if (stateApplicationitrr == stateApplicationFirst) {
                    this.currentLevel++;
                }
                break;
            }
        }
        applicationLogger.info("stateApplicationfinal" + stateApplicationfinal);
        return stateApplicationfinal;
    }

    @Override
    public boolean isFinalState(StateApplication other) {
        return this.stateApplicationFinal == other;
    }

    @Override
    public boolean isFirstState(StateApplication other) {
        return this.stateApplicationFirst == other;
    }
}
