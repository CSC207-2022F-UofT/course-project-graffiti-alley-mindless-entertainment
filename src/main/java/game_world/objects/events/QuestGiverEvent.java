package game_world.objects.events;

import game_world.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestGiverEvent extends Event {

    /**
     * Event executes when there is a quest to be given
     */

    private final String quest;
    private final String npc;
    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;

    // change below for inputs u want
    private final ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(
            "yes", "no"
    ));

    public String getNPC() {
        return this.npc;
    }

    public QuestGiverEvent(String name, String quest, String npc) {
        this.name = name;
        this.type = "Quest Giver";
        this.quest = quest;
        this.npc = npc;
        this.inputValidator = new WorldInputValidator(inputs);
        this.awaitInput = false;
        this.isDone = false;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        // change text below
        StringBuilder newMessage = new StringBuilder("[QUEST EVENT] What would you like to do?");
        for (String input : inputs) {
            newMessage.append("\n\t◈ ").append(input);
        }
        output.generateText(String.valueOf(newMessage));
    }

    @Override
    public void postInput(String input) {
        this.awaitInput = false;
        this.isDone = true;
        OutputHandler output = Output.getScreen();
        output.generateText("You decided to " + input + ".");
        if (input.equals("yes")) {
            // quest accepted, do what u need to here
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
