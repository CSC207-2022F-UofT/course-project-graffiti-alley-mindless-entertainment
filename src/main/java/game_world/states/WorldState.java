package game_world.states;

import interfaces.State;
import io.InputValidator;
import io.OutputHandlerImpl;
import objects.battle.SkillType;
import playercreation.PlayerCreatorInputValidator;
import playercreation.PlayerCreatorInteractor;
import playercreation.PlayerQuestion;

public class WorldState implements State {

    private final PlayerQuestion currQuestion;
    private boolean awaitInput;
    private boolean isDone;
    private final PlayerCreatorInteractor creatorInteractor;
    private final PlayerCreatorInputValidator inputValidator;

    public WorldState(PlayerQuestion currQuestion, PlayerCreatorInteractor creatorInteractor) {
        // Initializes a new PlayerQuestionState with currQuestion.
        this.currQuestion = currQuestion;
        this.awaitInput = false;
        this.isDone = false;
        this.creatorInteractor = creatorInteractor;
        this.inputValidator = new PlayerCreatorInputValidator(this.currQuestion);
    }

    public PlayerQuestion getCurrQuestion() {
        // Return the current PlayerQuestion.
        return this.currQuestion;
    }

    @Override
    public void preInput() {
        // Utilizes OutputHandler to ask the user a question based on the currQuestion.
        this.awaitInput = true;
        OutputHandlerImpl output = OutputHandlerImpl.getScreen();
        if (this.currQuestion == PlayerQuestion.NAME) {
            output.generateText("Welcome, weary traveler. May I ask what your name is?");
        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {
            output.generateText("Nice to meet you! Would you mind telling me a bit about yourself?");
        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {
            output.generateText("I sense an aura of magic within you. If I may ask, which of the four elements do you" +
                    " command? Air, Earth, Fire, or Water?");
        }
    }

    @Override
    public void postInput(String input) {
        // Saves user-inputted Player attributes into the PlayerCreatorInteractor. Assumes input has already been
        // parsed and validated.
        if (this.currQuestion == PlayerQuestion.NAME) {
            this.creatorInteractor.addName(input);
            this.isDone = true;
            this.awaitInput = false;
        }
        else if (this.currQuestion == PlayerQuestion.DESCRIPTION) {
            this.creatorInteractor.addDescription(input);
            this.isDone = true;
            this.awaitInput = false;
        }
        else if (this.currQuestion == PlayerQuestion.SKILLTYPE) {
            this.creatorInteractor.addSkillType(SkillType.valueOf(input.toUpperCase()));
            this.isDone = true;
            this.awaitInput = false;
        }
    }

    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }

}
