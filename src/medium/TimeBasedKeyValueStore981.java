package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore981 {

    private Map<String, List<Pair>> map;

    public TimeBasedKeyValueStore981() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";

        while (left <= right) {  // <=, а не <
            int mid = (left + right) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                // нашли подходящее значение
                res = list.get(mid).value;
                left = mid + 1; // ищем более поздний
            } else {
                right = mid - 1; // timestamp слишком большой
            }
        }

        return res;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
