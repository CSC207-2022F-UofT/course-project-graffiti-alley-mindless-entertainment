package interfaces;

import data_objects.EventData;
import org.json.simple.JSONObject;

public interface IDatabase {

    EventData fetchEvent(String key, Object value);

}
