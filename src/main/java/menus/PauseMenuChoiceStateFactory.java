package menus;

import core.ChoiceState;
import interfaces.State;

import java.util.List;

public class PauseMenuChoiceStateFactory {

    public PauseMenuChoiceStateFactory() {

    }


    public State createPauseMenuChoiceState(List<String> pauseOptions) {
        return new ChoiceState(pauseOptions, "What do you want to do?");
    }
}
