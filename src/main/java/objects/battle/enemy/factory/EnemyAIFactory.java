package objects.battle.enemy.factory;

import database.managers.AIDataManager;
import database.managers.EnemyDataManager;
import database.objects.AIData;
import database.objects.EnemyData;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.SmartAI;

import java.util.Objects;

public class EnemyAIFactory{

    private final AIDataManager aiDataManager;
    private final EnemyDataManager enemyDataManager;
    private final EnemyInfoFactory enemyInfoFactory;
    public EnemyAIFactory(AIDataManager aiDataManager, EnemyDataManager enemyDataManager, EnemyInfoFactory
                          enemyInfoFactory){
        this.aiDataManager = aiDataManager;
        this.enemyDataManager = enemyDataManager;
        this.enemyInfoFactory = enemyInfoFactory;
    }

    /**
     * This method returns the Enemy AI that the enemy with the name in the database has.
     * @param name of the enemy to create
     * @return instance enemy AI tha the enemy with the name has
     */
    public EnemyAI createEnemyAI(String name){
        EnemyData enemyData = this.enemyDataManager.fetchEnemyData(name);
        EnemyInfo enemyInfo = this.enemyInfoFactory.createEnemyInfo(name);
        EnemyAI AItype;
        String ai = enemyData.ai;
        AIData aiData = this.aiDataManager.fetchAIData(ai);
        if (Objects.equals(ai, "smart")) {
            AItype = new SmartAI(enemyInfo, Integer.parseInt(aiData.chance));
        } else{
            AItype = new DefaultAI(enemyInfo, Integer.parseInt(aiData.chance));
        }
        return AItype;
    }

}



