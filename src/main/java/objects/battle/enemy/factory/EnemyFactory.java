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

    /**
     * This method returns the enemy or boss instance using the information given by database
     * This method returns Enemy so if the boss is returned, make sure you cast, so that the object
     * is Boss.
     * @param name of the enemy to create
     * @return instance of enemy
     */
    public EnemyFighter createEnemy(String name) {
        EnemyData enemyData = this.enemyDatabase.fetchEnemyData(name);
        EnemyInfo enemyInfo = this.enemyInfoFactory.createEnemyInfo(enemyData);
        EnemyAI enemyAI = this.enemyAIFactory.createEnemyAI(enemyData, enemyInfo);
        if(enemyData.gimmick != null){
            GimmickStrategy gimmick = translateGimmick(enemyData.gimmick, enemyInfo);
            return new BossFacade(name, enemyInfo, enemyAI, gimmick);
        }
        return new EnemyFacade(enemyData.name, enemyInfo, enemyAI);
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
