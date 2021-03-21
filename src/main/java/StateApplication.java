public class StateApplication {
    private String commands;
    private int stateLevel;

    public StateApplication(String commands, int stateLevel) {
        this.commands = commands;
        this.stateLevel = stateLevel;
    }

    public String getCommands() {
        return commands;
    }

    public int getStateLevel() {
        return stateLevel;
    }


}
