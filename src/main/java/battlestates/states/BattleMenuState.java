package battlestates.states;

import battlestates.BattleChoiceType;
import objects.character.Player;

import java.util.List;

public class BattleMenuState extends BattleAskingState{

    public BattleMenuState(Player user, BattleChoiceType prevChoice, List<String> options) {
        super(user, prevChoice, options);
    }

    /**
     * Asks the user for input on what action they should do
     */
    @Override
    public void preInput() {
        output.generateTextWithOptions("Select an option: ", this.options);
        this.awaitingInput = true;
    }

    /**
     * @param input from the user
     *              Executes when the state is awaiting input
     */
    @Override
    public void postInput(String input) {
        String cleanInput = inputValidator.parseAndValidate(input);
        if (isValidInp(cleanInput)) {

        }
    }

}
