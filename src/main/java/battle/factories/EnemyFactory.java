package battle.factories;

import battle.use_cases.gimmick.GimmickStrategy;
import battle.entities.gimmick.GimmickType;
import battle.entities.gimmick.StatGimmickEntity;
import battle.use_cases.gimmick.StatGimmickStrategy;
import database.managers.AIDataManager;
import database.managers.EnemyDataManager;
import database.managers.GimmickDataManager;
import database.managers.SkillDataManager;
import database.entities.EnemyData;
import database.entities.GimmickData;
import battle.entities.SkillType;
import battle.entities.EnemyInfo;
import battle.use_cases.ai.EnemyAI;
import character.BossFacade;
import character.EnemyFacade;
import character.EnemyFighter;

/**
 * This class creates EnemyFighter object using the given name. It uses EnemyAIFactory and
 * EnemyInfoFactory to creates the instance of enemyFighter
 *
 */
public class EnemyFactory {
    /**
     * enemyDatabase: This is used to get information about the enemies from the database
     * enemyInfoFactory: factory used to create the enemyInfo that this enemy has
     * enemyAUFactory: factory used to create an AI that this enemy has
     * gimmickDataManager: Manager used to get the information about the gimmick from the database
     */
    private final EnemyDataManager enemyDatabase;
    private final EnemyInfoFactory enemyInfoFactory;
    private final EnemyAIFactory enemyAIFactory;
    private final GimmickDataManager gimmickDataManager;

    /**
     * This is the constructor of EnemyFactory
     */
    public EnemyFactory() {
        this.enemyDatabase = new EnemyDataManager();
        AIDataManager aiDataManager = new AIDataManager();
        SkillDataManager skillDataManager = new SkillDataManager();
        this.enemyInfoFactory = new EnemyInfoFactory(skillDataManager);
        this.enemyAIFactory = new EnemyAIFactory(aiDataManager);
        this.gimmickDataManager = new GimmickDataManager();

    }

    private EnemyData getEnemyData(String name){
        return this.enemyDatabase.fetchEnemyData(name);
    }

    private EnemyInfo getEnemyInfo(EnemyData enemyData){
        return this.enemyInfoFactory.createEnemyInfo(enemyData);
    }

    private EnemyAI getEnemyAI(EnemyData enemyData, EnemyInfo enemyInfo){
        return this.enemyAIFactory.createEnemyAI(enemyData, enemyInfo);
    }

    /**
     * This method returns the enemy instance using the information given by database
     * @param name of the enemy to create
     * @return instance of enemy
     */
    public EnemyFighter createEnemy(String name) {
        EnemyData enemyData = getEnemyData(name);
        EnemyInfo enemyInfo = getEnemyInfo(getEnemyData(name));
        if (!(enemyData.gimmick == null)) {
            return new BossFacade(name, enemyInfo, getEnemyAI(getEnemyData(name),
                    getEnemyInfo(getEnemyData(name))), translateGimmick(enemyData.gimmick, enemyInfo));
        }
        return new EnemyFacade(name, getEnemyInfo(getEnemyData(name)), getEnemyAI(getEnemyData(name),
                getEnemyInfo(getEnemyData(name))));
    }

    /**
     * This method returns the type gimmick depending on the string in the database
     * @param name of the enemy to create
     * @param enemyInfo EnemeyInfo of the name given
     * @return gimmick that the enemy has (from the database)
     */
    public GimmickStrategy translateGimmick(String name, EnemyInfo enemyInfo) {
        switch (name) {
            case "health":{
                GimmickData healthGimmickData = this.gimmickDataManager.fetchGimmickData(name);
                int triggerHealth = Integer.parseInt(healthGimmickData.trigger);
                StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.HEALTH,
                        enemyInfo, triggerHealth).build();
                return new StatGimmickStrategy(gimmick);
            }
            case "attack":{
                GimmickData attackGimmickData = this.gimmickDataManager.fetchGimmickData(name);
                int triggerHealth = Integer.parseInt(attackGimmickData.trigger);
                double attackIncrease = Double.parseDouble(attackGimmickData.attack);
                StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.ATTACK, enemyInfo,
                        triggerHealth).setAttackIncrease(attackIncrease).build();
                return new StatGimmickStrategy(gimmick);
            }
            case "speed":{
                GimmickData speedGimmickData = this.gimmickDataManager.fetchGimmickData(name);
                int triggerHealth = Integer.parseInt(speedGimmickData.trigger);
                int speedIncrease = Integer.parseInt(speedGimmickData.speed);
                StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.SPEED, enemyInfo,
                        triggerHealth).setSpeedIncrease(speedIncrease).build();
                return new StatGimmickStrategy(gimmick);
            }
            case "type":{
                GimmickData typeGimmickData = this.gimmickDataManager.fetchGimmickData(name);
                int triggerHealth = Integer.parseInt(typeGimmickData.trigger);
                SkillType type = enemyInfo.getType();
                if(type == SkillType.WATER){
                    StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.TYPE, enemyInfo,
                            triggerHealth).setNewType(SkillType.FIRE).build();
                    return new StatGimmickStrategy(gimmick);
                } else if(type == SkillType.FIRE){
                    StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.TYPE, enemyInfo,
                            triggerHealth).setNewType(SkillType.EARTH).build();
                    return new StatGimmickStrategy(gimmick);
                } else if(type == SkillType.EARTH){
                    StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.TYPE, enemyInfo,
                            triggerHealth).setNewType(SkillType.AIR).build();
                    return new StatGimmickStrategy(gimmick);
                } else{
                    StatGimmickEntity gimmick = new StatGimmickEntity.StatGimmickBuilder(GimmickType.TYPE, enemyInfo,
                            triggerHealth).setNewType(SkillType.WATER).build();
                    return new StatGimmickStrategy(gimmick);
                }

            }
        }
        return null;
    }


}
