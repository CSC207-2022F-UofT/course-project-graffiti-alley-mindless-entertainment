package objects.battle.enemy.factory;

import database.managers.EnemyDataManager;
import database.objects.EnemyData;
import objects.battle.enemy.EnemyInfo;
import objects.battle.enemy.ai.EnemyAI;
import objects.battle.enemy.gimmick.*;
import objects.character.Boss;
import objects.character.Enemy;


public class EnemyFactory {

    /**
     * This method returns the enemy or boss instance using the information given by database
     * This method returns Enemy so if the boss is returned, make sure you cast, so that the object
     * is Boss.
     * @param name of the enemy to create
     * @return instance of enemy
     */
    public static Enemy createEnemy(String name) throws Exception {
        EnemyInfo enemyInfo = EnemyInfoFactory.createEnemyInfo(name);
        EnemyAI enemyAI = EnemyAIFactory.createEnemyAI(name);
        EnemyDataManager data = new EnemyDataManager();
        EnemyData enemyData = data.fetchEnemyData(name);
        if(!(enemyData.gimmick ==null)){
            Gimmick gimmick = translateGimmick(enemyData.gimmick, enemyInfo);
            return new Boss(name, enemyInfo, enemyAI, gimmick);
        }
        return new Enemy(enemyData.name, enemyInfo, enemyAI);
    }

    /**
     * This method returns the type gimmick depending on the string in the database
     * @param name of the enemy to create
     * @param enemyInfo EnemeyInfo of the name given
     * @return gimmick that the enemy has (from the database)
     */
    public static Gimmick translateGimmick(String name, EnemyInfo enemyInfo){
        switch (name) {
            case "health":{
                return new HealthGimmick(enemyInfo);
            }
            case "attack":{
                return new AttackGimmick(enemyInfo);
            }
            case "speed":{
                return new SpeedGimmick(enemyInfo);
            }
            case "type":{
                return new TypeGimmick(enemyInfo);
            }
        }
        return new HealthGimmick(enemyInfo);
    }


}
