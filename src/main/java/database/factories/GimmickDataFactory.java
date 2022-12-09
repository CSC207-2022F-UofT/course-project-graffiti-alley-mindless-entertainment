package database.factories;

import database.entities.GimmickData;
import org.json.simple.JSONObject;

public class GimmickDataFactory {

    /**
     * @param jsonObject JSONObject with all information regarding event
     * @return GimmickData with all instance attributes converted from jsonObject
     */
    public GimmickData createGimmickData(JSONObject jsonObject) {
        if (jsonObject.containsKey("attack")) {
            return new GimmickData(
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("trigger"),
                    (String) jsonObject.get("attack")
            );
        } else if (jsonObject.containsKey("speed")) {
            return new GimmickData(
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("trigger"),
                    (String) jsonObject.get("speed")
            );
        }
        else {
            return new GimmickData(
                    (String) jsonObject.get("name"),
                    (String) jsonObject.get("trigger")
            );
        }
    }

}
