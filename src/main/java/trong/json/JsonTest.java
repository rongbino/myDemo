package trong.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
    public static void main(String[] args) {
        JsonArray array = new JsonArray();
        JsonObject obj = new JsonObject();
        obj.addProperty("num",4);
        obj.addProperty("name", "name");
        array.add(obj);

        System.out.println(array.get(array.size()-1).getAsJsonObject().get("num").getAsInt());

        HashMap<String, Object> f = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        HashMap<String, Map<String, String>>  map = new HashMap<>();
        HashMap<String, String> vl = new HashMap<>();
        vl.put("key", "value");
        map.put("map", vl);

        f.put("list", list);
        f.put("enum", map);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(f));
        } catch (Exception e) {
            e.toString();
        }
    }
}
