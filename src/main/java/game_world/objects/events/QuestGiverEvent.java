package game_world.objects.events;

import game_world.WorldInputValidator;
import io.InputValidator;
import io.Output;
import io.OutputHandler;
import quests.QuestInteractor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains QuestGiverEvent, which is executed when there is a quest to be given
 */
public class QuestGiverEvent extends Event {

    /**
     * Attributes.
     */
    private final String quest;
    private final String npc;
    private final WorldInputValidator inputValidator;
    private boolean isDone;
    private boolean awaitInput;
    private final QuestInteractor questInteractor;
    private final ArrayList<String> inputs = new ArrayList<>(Arrays.asList(
            "yes", "no"
    ));

    /**
     * Constructor.
     */
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

    /**
     * @return name of the npc.
     */
    public String getNPC() {
        return this.npc;
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

    /**
     * Executes when the state is awaiting input.
     * @param input from the user
     */
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

    /**
     * @return whether the QuestGiverEvent object is awaiting input or not.
     */
    @Override
    public boolean awaitInput() {
        return this.awaitInput;
    }

    /**
     * @return whether the QuestGiverEvent is done or not.
     */
    @Override
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * @return the input validator.
     */
    @Override
    public InputValidator getInputValidator() {
        return this.inputValidator;
    }
}
