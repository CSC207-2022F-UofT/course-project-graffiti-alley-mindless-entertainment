package battle.use_cases;

import character.EnemyFighter;
import character.entities.Player;

public class BattleEntityInteractor {
    /**
     * Attributes:
     * user: Player object being interacted with
     * foe: EnemyFighter object being interacted with
     */
    private Player user;
    private EnemyFighter foe;
    public BattleEntityInteractor(Player user, EnemyFighter foe) {
        this.user = user;
        this.foe = foe;
    }
    public BattleEntityInteractor(Player user) {
        this.user = user;
    }

    /**
     * @return Player object representing user
     */
    public Player getUser() {
        return this.user;
    }

    /**
     * @return EnemyFighter object representing foe
     */
    public EnemyFighter getFoe() {
        return this.foe;
    }
    public void setFoe(EnemyFighter foe) {
        this.foe = foe;
    }

    /**
     * Returns true if dead, false if not.
     * @return
     */
    public boolean isUserDead() {
        return user.getCurrHealth() <= 0;
    }
    public boolean isFoeDead() {
        return !foe.checkAlive();
    }
    /**
     * Returns true when user outspeeds foe, false otherwise (wins ties)
     * @return whether user speed is greater than or equal to foe
     */
    public boolean userOutspeeds() {
        return user.getSpeed() >= foe.getSpeed();
    }
}
