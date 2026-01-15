import java.util.Hashtable;

class HashtableAll {

    public static void main(String[] args) {

        /* -------------------- CONSTRUCTORS -------------------- */

        // Default constructor
        Hashtable<Integer, String> table1 = new Hashtable<>();

        // Constructor with initial capacity
        Hashtable<Integer, String> table2 = new Hashtable<>(10);

        // Constructor with capacity and load factor
        Hashtable<Integer, String> table3 = new Hashtable<>(10, 0.75f);

        // Constructor with another map
        Hashtable<Integer, String> table4 = new Hashtable<>(table1);

        /* -------------------- METHODS -------------------- */

        // 1. put()
        table1.put(1, "One");
        table1.put(2, "Two");

        // 2. get()
        System.out.println(table1.get(1));

        // 3. remove()
        table1.remove(2);

        // 4. containsKey()
        System.out.println(table1.containsKey(1));

        // 5. containsValue()
        System.out.println(table1.containsValue("One"));

        // 6. size()
        System.out.println(table1.size());

        // 7. isEmpty()
        System.out.println(table1.isEmpty());

        // 8. keySet()
        System.out.println(table1.keySet());

        // 9. values()
        System.out.println(table1.values());

        // 10. entrySet()
        System.out.println(table1.entrySet());

        // 11. putIfAbsent()
        table1.putIfAbsent(3, "Three");

        // 12. replace()
        table1.replace(1, "ONE");

        // 13. equals()
        System.out.println(table1.equals(table4));

        // 14. clear()
        table2.clear();

        // 15. hashCode()
        System.out.println(table1.hashCode());

        System.out.println(table1);
    }
}
