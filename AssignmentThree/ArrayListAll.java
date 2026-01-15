import java.util.ArrayList;
import java.util.Collection;

class ArrayListAll {

    public static void main(String[] args) {

        /* -------------------- CONSTRUCTORS -------------------- */

        // Default constructor (initial capacity = 10)
        ArrayList<String> list1 = new ArrayList<>();

        // Constructor with initial capacity
        ArrayList<String> list2 = new ArrayList<>(5);

        // Constructor using another collection
        Collection<String> temp = new ArrayList<>();
        temp.add("Temp1");
        temp.add("Temp2");
        ArrayList<String> list3 = new ArrayList<>(temp);

        /* -------------------- METHODS -------------------- */

        // 1. add() – adds element to list
        list1.add("Java");
        list1.add("Python");

        // 2. add(index, element) – inserts at index
        list1.add(1, "C++");

        // 3. addAll() – adds another collection
        list1.addAll(list3);

        // 4. get() – retrieves element
        System.out.println(list1.get(0));

        // 5. set() – replaces element
        list1.set(0, "Java SE");

        // 6. remove(Object) – removes element
        list1.remove("Temp1");

        // 7. remove(index) – removes by index
        list1.remove(1);

        // 8. size() – number of elements
        System.out.println(list1.size());

        // 9. contains() – checks existence
        System.out.println(list1.contains("Python"));

        // 10. indexOf() – first index of element
        System.out.println(list1.indexOf("Python"));

        // 11. lastIndexOf() – last index of element
        System.out.println(list1.lastIndexOf("Python"));

        // 12. isEmpty() – checks if empty
        System.out.println(list1.isEmpty());

        // 13. toArray() – converts to array
        Object[] arr = list1.toArray();

        // 14. clear() – removes all elements
        list2.clear();

        // 15. ensureCapacity() – increases capacity
        list1.ensureCapacity(20);

        // 16. trimToSize() – trims capacity
        list1.trimToSize();

        // Display final list
        System.out.println(list1);
    }
}
