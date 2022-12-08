package game_world.objects.events;

import game_world.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import quests.Quest;
import quests.QuestInteractor;

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

    private QuestInteractor questInteractor;

    // change below for inputs u want
    private final ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(
            "yes", "no"
    ));

    public String getNPC() {
        return this.npc;
    }

    public QuestGiverEvent(String name, String quest, String npc, QuestInteractor questInteractor) {
        this.name = name;
        this.type = "Quest Giver";
        this.quest = quest;
        this.npc = npc;
        this.inputValidator = new WorldInputValidator(inputs);
        this.awaitInput = false;
        this.isDone = false;
        this.questInteractor = questInteractor;
    }

    @Override
    public void preInput() {
        this.awaitInput = true;
        OutputHandler output = Output.getScreen();
        StringBuilder newMessage = new StringBuilder("[QUEST EVENT] Would you like to accept this quest?");
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
        if (input.equals("yes")) {
            output.generateText("You decided to accept the quest. Good Luck!");
            this.questInteractor.addQuest(this.quest);
        } else {
            output.generateText("You decided to reject the quest.");
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
