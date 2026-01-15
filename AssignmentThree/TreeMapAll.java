import java.util.TreeMap;
import java.util.Map;

class TreeMapAll {

    public static void main(String[] args) {

        /* -------------------- CONSTRUCTORS -------------------- */

        // Default constructor (natural sorting)
        TreeMap<Integer, String> tm1 = new TreeMap<>();

        // Constructor with another map
        TreeMap<Integer, String> tm2 = new TreeMap<>(tm1);

        // Constructor with SortedMap
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);

        /* -------------------- METHODS -------------------- */

        // 1. put()
        tm1.put(3, "C");
        tm1.put(1, "A");
        tm1.put(2, "B");

        // 2. get()
        System.out.println(tm1.get(1));

        // 3. remove()
        tm1.remove(2);

        // 4. containsKey()
        System.out.println(tm1.containsKey(3));

        // 5. containsValue()
        System.out.println(tm1.containsValue("A"));

        // 6. size()
        System.out.println(tm1.size());

        // 7. isEmpty()
        System.out.println(tm1.isEmpty());

        // 8. firstKey()
        System.out.println(tm1.firstKey());

        // 9. lastKey()
        System.out.println(tm1.lastKey());

        // 10. higherKey()
        System.out.println(tm1.higherKey(1));

        // 11. lowerKey()
        System.out.println(tm1.lowerKey(3));

        // 12. descendingMap()
        System.out.println(tm1.descendingMap());

        // 13. keySet()
        System.out.println(tm1.keySet());

        // 14. values()
        System.out.println(tm1.values());

        // 15. entrySet()
        System.out.println(tm1.entrySet());

        System.out.println(tm1);
    }
}
