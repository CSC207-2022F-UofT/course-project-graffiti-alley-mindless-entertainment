package objects.battle.enemy.factory;

import database.managers.AIDataManager;
import database.managers.EnemyDataManager;
import database.managers.GimmickDataManager;
import database.managers.SkillDataManager;
import database.objects.EnemyData;
import database.objects.GimmickData;
import objects.battle.SkillType;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.gimmick.*;
import objects.character.BossFacade;
import objects.character.EnemyFacade;
import objects.character.EnemyFighter;


public class EnemyFactory {

    private final EnemyDataManager enemyDatabase;
    private final AIDataManager aiDataManager;
    private final EnemyInfoFactory enemyInfoFactory;
    private final SkillDataManager skillDataManager;
    private final EnemyAIFactory enemyAIFactory;
    private final GimmickDataManager gimmickDataManager;
    public EnemyFactory() {
        this.enemyDatabase = new EnemyDataManager();
        this.aiDataManager = new AIDataManager();
        this.skillDataManager = new SkillDataManager();
        this.enemyInfoFactory = new EnemyInfoFactory(this.enemyDatabase, this.skillDataManager);
        this.enemyAIFactory = new EnemyAIFactory(this.aiDataManager, this.enemyDatabase, this.enemyInfoFactory);
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
    public EnemyFacade createEnemy(String name){
        return new EnemyFacade(name, getEnemyInfo(getEnemyData(name)), getEnemyAI(getEnemyData(name),
                getEnemyInfo(getEnemyData(name))));
    }

    /**
     * This method returns the boss instance using the information given by database
     * @param name of the enemy to create
     * @return instance of boss
     */
    public BossFacade createBoss(String name){
        EnemyData enemyData = getEnemyData(name);
        EnemyInfo enemyInfo = getEnemyInfo(getEnemyData(name));
        return new BossFacade(name, enemyInfo, getEnemyAI(getEnemyData(name),
                getEnemyInfo(getEnemyData(name))), translateGimmick(enemyData.gimmick, enemyInfo));



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
