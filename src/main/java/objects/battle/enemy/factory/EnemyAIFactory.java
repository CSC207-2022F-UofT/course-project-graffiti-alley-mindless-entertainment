package objects.battle.enemy.factory;

import database.managers.AIDataManager;
import database.objects.AIData;
import database.objects.EnemyData;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.DefaultAI;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.ai.SmartAI;

import java.util.Objects;

public class EnemyAIFactory{

    private final AIDataManager aiDataManager;

    public EnemyAIFactory(AIDataManager aiDataManager){
        this.aiDataManager = aiDataManager;
    }

    /**
     * This method returns the Enemy AI that the enemy with the name in the database has.
     * @param enemyInfo of the enemy to create
     * @param enemyData of the enemy from the database
     * @return instance enemy AI tha the enemy with the name has
     */
    public EnemyAI createEnemyAI(EnemyData enemyData, EnemyInfo enemyInfo){
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



