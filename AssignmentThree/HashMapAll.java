import java.util.HashMap;
import java.util.Map;

class HashMapAll {

    public static void main(String[] args) {

        /* -------------------- CONSTRUCTORS -------------------- */

        // Default constructor
        HashMap<Integer, String> map1 = new HashMap<>();

        // Constructor with initial capacity
        HashMap<Integer, String> map2 = new HashMap<>(10);

        // Constructor with capacity and load factor
        HashMap<Integer, String> map3 = new HashMap<>(10, 0.75f);

        // Constructor with another map
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        /* -------------------- METHODS -------------------- */

        // 1. put()
        map1.put(1, "Java");
        map1.put(2, "Python");

        // 2. putIfAbsent()
        map1.putIfAbsent(3, "C++");

        // 3. get()
        System.out.println(map1.get(1));

        // 4. remove(key)
        map1.remove(2);

        // 5. containsKey()
        System.out.println(map1.containsKey(1));

        // 6. containsValue()
        System.out.println(map1.containsValue("Java"));

        // 7. size()
        System.out.println(map1.size());

        // 8. isEmpty()
        System.out.println(map1.isEmpty());

        // 9. keySet()
        System.out.println(map1.keySet());

        // 10. values()
        System.out.println(map1.values());

        // 11. entrySet()
        System.out.println(map1.entrySet());

        // 12. replace()
        map1.replace(1, "Java SE");

        // 13. getOrDefault()
        System.out.println(map1.getOrDefault(5, "Not Found"));

        // 14. clear()
        map2.clear();

        // 15. equals()
        System.out.println(map1.equals(map4));

        System.out.println(map1);
    }
}
