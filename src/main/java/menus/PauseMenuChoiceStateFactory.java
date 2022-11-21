package menus;

import core.ChoiceState;
import interfaces.State;

import java.util.Arrays;
import java.util.List;

public class PauseMenuChoiceStateFactory {

    //private List<String> pauseOptions;
    private List<String> pauseOptionsDisplayText;

    public PauseMenuChoiceStateFactory() {

        //in the future can change this to fetch from a database/properties file
        //pauseOptions = Arrays.asList("options", "save");
        pauseOptionsDisplayText = Arrays.asList("Change options", "Save the game");
    }


    public State createPauseMenuChoiceState(List<String> pauseOptions) {
        return new ChoiceState(pauseOptions, pauseOptionsDisplayText);
    }
}
