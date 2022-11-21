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

    /**
     * This method returns the Enemy AI that the enemy with the name in the database has.
     * @param name of the enemy to create
     * @return instance enemy AI tha the enemy with the name has
     */
    public static EnemyAI createEnemyAI(String name) throws TypeNotFoundException {
        EnemyDataManager data = new EnemyDataManager();
        EnemyData enemyData = data.fetchEnemyData(name);
        EnemyInfo enemyInfo = EnemyInfoFactory.createEnemyInfo(name);
        EnemyAI AItype;
        String ai = enemyData.ai;
        AIDataManager dataAI = new AIDataManager();
        AIData aiData = dataAI.fetchAIData(ai);
        if (Objects.equals(ai, "smart")) {
            AItype = new SmartAI(enemyInfo, Integer.parseInt(aiData.chance));
        } else{
            AItype = new DefaultAI(enemyInfo, Integer.parseInt(aiData.chance));
        }
        return AItype;
    }

}



