package inventory;

import battle.use_cases.BattleEntityInteractor;
import inventory.entities.item.Armor;
import inventory.entities.item.Item;
import inventory.entities.item.Potion;
import inventory.entities.item.Sword;

public class UseItemHandler {
    /**
     * Use case for using item's abilities
     * Attributes:
     * fighters: Battle entities participating in the exchange of stats.
     */
    private final BattleEntityInteractor fighters;
    public UseItemHandler(BattleEntityInteractor fighters) {
        this.fighters = fighters;
    }

    /**
     * Uses the item's ability
     * @param item that is being used
     */
    public void useItemAbility(Item item) {
        if (item instanceof Potion) {
            fighters.getUser().changeCurrHealth((item.getLevel() + 1) * 10);
        } else if (item instanceof Sword) {
            fighters.getFoe().changeHealth(-(item.getLevel() + 1) * 10);
        } else if (item instanceof Armor) {
            fighters.getUser().changeArmor((item.getLevel() + 1) * 10);
        }
    }
}
