package battlestates.states;

import battlestates.BattleChoiceType;
import core.ChoiceInputValidator;
import game.GameEntities;
import io.Output;
import objects.battle.*;
import objects.battle.enemy.SkillHelper;
import objects.character.Player;
import objects.inventory.Inventory;
import objects.item.Item;

import java.awt.*;
import java.util.List;

public class BattleItemChoiceState extends BattleAskingState {
    private final SkillHelper skillHelper = new SkillHelper();
    private Inventory inventory;
    private UseItemHandler itemHandler;

    public BattleItemChoiceState(BattleEntityInteractor fighters, BattleChoiceType prevChoice) {
        super(fighters, prevChoice);
        this.user = fighters.getUser();
        this.foe = fighters.getFoe();
        this.inventory = Player.getInventory();
        this.options = inventory.toStringList();
        this.options.add("Back");
        this.inputValidator = new ChoiceInputValidator(options);
        this.itemHandler = new UseItemHandler(fighters);
    }
    @Override
    public void preInput() {
        output.generateTextWithOptions("Pick an item to use: ", options);
        this.awaitingInput = true;
    }
    public void postInput(String input) {
        String cleanInput = inputValidator.parseAndValidate(input);
        if (isValidInp(cleanInput)) {
            if (cleanInput.equals("back")) {
                currChoice = BattleChoiceType.MENU;
            } else {
                StatDisplayer statDisplayer = new StatDisplayer();
                Item chosenItem = inventory.useItem(cleanInput);
                itemHandler.useItemAbility(chosenItem);
                user.changeSpeed(-10);

                statDisplayer.displayPreBar();
                output.generateText(chosenItem.getName() + ": " + chosenItem.getAbility());
                statDisplayer.displayPostBar();
                statDisplayer.displayStats(user, foe);
            }
            this.awaitingInput = false;
            this.done = true;
        }
    }
}
