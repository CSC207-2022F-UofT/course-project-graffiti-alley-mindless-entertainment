package objects.battle.enemy.gimmick;

import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
/** This class is the entity of gimmick that holds information about the gimmick
 */
public class StatGimmickEntity {
    /**
     * name: name of the gimmick in enum
     * enemyInfo: information about the enemy who is using this gimmick
     * triggerHealth: enemy's health that the gimmick is triggered
     * speedIncrease: The speed that increases when the speed gimmick is triggered
     * attackIncrease: The amount in double that the damage to the enemy's skills are multiplied by
     * type: the type that the boss changes to as a result of the type gimmick
     * usedGimmick: keeps track of whether the gimmick is used or not
     */
    private final GimmickType name;
    private final EnemyInfo enemyInfo;
    private final int triggerHealth;
    private final int speedIncrease;
    private final double attackIncrease;
    private final SkillType type;
    private boolean usedGimmick = false;

    /** This is a constructor of the gimmick class that takes name, enemyinfo, triggger health,
     * speed, attack, and type as parameters.
     */
    public StatGimmickEntity(StatGimmickBuilder builder){
        this.name = builder.name;
        this.enemyInfo = builder.enemyInfo;
        this.triggerHealth = builder.triggerHealth;
        this.speedIncrease = builder.speedIncrease;
        this.attackIncrease = builder.attackIncrease;
        this.type = builder.type;
    }

    /** This method will set the UsedGimmick to true. it is used once the gimmick is used
     */
    public void usedGimmick(){
        this.usedGimmick = true;
    }

    /** This method returns the enemyInfo that the gimmick has.
     * @return EnemyInfo that has information about the enemy
     */
    public EnemyInfo getEnemyInfo(){
        return this.enemyInfo;
    }

    /** this method returns the TriggerHealth
     * @return health that the gimmick is triggered in int
     */
    public int getTriggerHealth(){
        return this.triggerHealth;
    }

    /** This method checks if the gimmick has been used or not
     * @return true of the gimmick has already been used and false if is hasn't been used
     */
    public boolean getUsedGimmick(){
        return this.usedGimmick;
    }

    /** This method returns name of the gimmick in enum
     * @return the name of the gimmick in enum
     */
    public GimmickType getName(){
        return this.name;
    }

    /** This method returns the speedIncrease
     * @return speed that the gimmick will increase in int
     */
    public int getSpeedIncrease() {
        return this.speedIncrease;
    }

    /** This method returns the AttackIncrease
     * @return damage that the gimmick will increase in int
     */
    public double getAttackIncrease() {
        return this.attackIncrease;
    }

    /** This method returns the type that the enemy gets as a result of the gimmick
     * @return type of the enemy after the gimmick is used in SkillType
     */
    public SkillType getType(){
        return this.type;
    }

    public static class StatGimmickBuilder{
        private final GimmickType name;
        private final EnemyInfo enemyInfo;
        private final int triggerHealth;

        private int speedIncrease;
        private double attackIncrease;
        private SkillType type;

        /**
         * This method is a constructor of the builder class
         * @param enemyInfo : information about the enemy
         * @param name : name of the gimmick
         * @param triggerHealth : health that the gimmick is triggered at
         */
        public StatGimmickBuilder(GimmickType name, EnemyInfo enemyInfo, int triggerHealth){
            this.name = name;
            this.enemyInfo = enemyInfo;
            this.triggerHealth = triggerHealth;
        }

        /**
         * This method sets the speedIncrease attribute
         * @param speedIncrease : speed that increases as result of the speed gimmick
         * @return the StatGimmickBuilder object
         */
        public StatGimmickBuilder setSpeedIncrease(int speedIncrease){
            this.speedIncrease = speedIncrease;
            return this;
        }

        /**
         * This method sets the attackIncrease attribute
         * @param attackIncrease : attack that increases as result of the attack gimmick
         * @return the StatGimmickBuilder object
         */
        public StatGimmickBuilder setAttackIncrease(double attackIncrease){
            this.attackIncrease = attackIncrease;
            return this;
        }

        /**
         * This method sets the type attribute
         * @param type : type that the boss changes to as a result of the type gimmick
         * @return the StatGimmickBuilder object
         */
        public StatGimmickBuilder setNewType(SkillType type){
            this.type = type;
            return this;
        }

        /**
         * This method returns the StatGimmickEntity object with the given attributes
         * @return the StatGimmickEntity with the attributes
         */
        public StatGimmickEntity build(){
            return new StatGimmickEntity(this);
        }
    }
}
