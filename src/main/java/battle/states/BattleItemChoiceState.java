package battle.states;

import battle.entities.BattleChoiceType;
import battle.use_cases.BattleEntityInteractor;
import battle.use_cases.StatDisplayer;
import core.ChoiceInputValidator;
import battle.use_cases.SkillHelper;
import character.entities.Player;
import inventory.entities.Inventory;
import inventory.entities.item.Item;
import inventory.UseItemHandler;

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
