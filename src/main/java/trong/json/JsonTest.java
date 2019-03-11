package trong.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonTest {
    public static void main(String[] args) {
        JsonArray array = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("num",4);
        obj.addProperty("name", "name");
        array.add(obj);

        System.out.println(array.get(array.size()-1).getAsJsonObject().get("num").getAsInt());
    }
}
