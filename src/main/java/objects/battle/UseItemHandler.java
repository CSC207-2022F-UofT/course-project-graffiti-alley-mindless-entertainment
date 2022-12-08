package objects.battle;

import objects.item.Armor;
import objects.item.Item;
import objects.item.Potion;
import objects.item.Sword;

public class UseItemHandler {
    /**
     * Use case for using item's abilities
     * Attributes:
     * fighters: Battle entities participating in the exchange of stats.
     */
    private BattleEntityInteractor fighters;
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
