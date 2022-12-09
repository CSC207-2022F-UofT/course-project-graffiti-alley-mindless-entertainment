package battle.factories;

import database.managers.AIDataManager;
import database.entities.AIData;
import database.entities.EnemyData;
import battle.entities.EnemyInfo;
import battle.use_cases.ai.DefaultAI;
import battle.use_cases.ai.EnemyAI;
import battle.use_cases.ai.SmartAI;

import java.util.Objects;

/**
 * This class creates an enemyAI using the given information. It creates either default AI or smart AI
 */
public class EnemyAIFactory{
    /**
     * aiDataManager: this is for the class to get information about the AI
     */
    private final AIDataManager aiDataManager;

    /**
     * This is a constructor of EnemyAIFactory
     * @param aiDataManager : information about the AI from the database
     */
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



