package game_world.objects.states;

import game_world.WorldInputValidator;
import game_world.objects.Area;
import interfaces.State;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import options.Options;

import java.util.ArrayList;

public class DialogueState implements State {

    /**
     * State for when there is dialogue to be shown on screen
     * Clicking enter will continue to next state
     */

    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;
    private final Area currentArea;
    private final ArrayList<String> allTexts;
    private StringBuilder nextText;

    private void updateNextText() {
        this.nextText = new StringBuilder(allTexts.get(this.currentArea.getCurrTextIndex()));
        this.currentArea.setCurrTextIndex(this.currentArea.getCurrTextIndex() + 1);
        int textIndex = 1;
        while (this.currentArea.getCurrTextIndex() < allTexts.size() && textIndex < Options.getOptions().getTextSpeed()) {
            this.nextText.append("\n");
            this.nextText.append(this.currentArea.getTexts().get(this.currentArea.getCurrTextIndex()));
            this.currentArea.setCurrTextIndex(this.currentArea.getCurrTextIndex() + 1);
            textIndex += 1;
        }
    }

    public DialogueState(Area currentArea) {
        this.currentArea = currentArea;
        this.allTexts = this.currentArea.getTexts();
        this.inputValidator = new WorldInputValidator();
        this.awaitInput = false;
        this.isDone = false;
        updateNextText();

        OutputHandler output = Output.getScreen();
        output.generateText("◈ " + this.currentArea.getSpeaker() + " ◈");
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        output.generateText(String.valueOf(this.nextText));
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        if (this.currentArea.getCurrTextIndex() == allTexts.size())
            this.isDone = true;
        else
            updateNextText();
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
