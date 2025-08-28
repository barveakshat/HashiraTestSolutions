import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args)throws Exception {
        JSONObject json = new JSONObject(new JSONTokener(new FileReader("input.json")));
        JSONObject keys = json.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");

        Map<Integer, Integer> yValues = new HashMap<>();
        for (Object keyObj : json.keySet()) {
            String key = (String) keyObj;
            if (!key.equals("keys")) {
                JSONObject root = json.getJSONObject(key);
                int x = Integer.parseInt(key);
                String base = root.getString("base");
                String value = root.getString("value");

                int y = Integer.parseInt(value, Integer.parseInt(base));
                yValues.put(x, y);
                System.out.println("x = " + x + ", y = " + y + " (base " + base + ")");
            }
        }


        int c = 0;
        for (int val : yValues.values()) {
            c += val;
        }
        System.out.println("Secret c is : " + c);

    }
}
