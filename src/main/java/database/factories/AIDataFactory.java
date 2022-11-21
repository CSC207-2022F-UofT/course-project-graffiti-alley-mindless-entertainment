package database.factories;

import org.json.simple.JSONObject;
import database.objects.AIData;

public class AIDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return AIData with all instance attributes converted from jsonObject
     */
    public AIData createAIData(JSONObject jsonObject) {
        return new AIData(
                (String) jsonObject.get("name"),
                (String) jsonObject.get("chance")
        );
    }

}
