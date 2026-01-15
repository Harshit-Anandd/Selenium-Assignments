import java.util.Vector;

class VectorAll {

    public static void main(String[] args) {

        /* -------------------- CONSTRUCTORS -------------------- */

        // Default constructor
        Vector<Integer> v1 = new Vector<>();

        // Constructor with initial capacity
        Vector<Integer> v2 = new Vector<>(5);

        // Constructor with capacity and increment
        Vector<Integer> v3 = new Vector<>(5, 3);

        // Constructor with collection
        Vector<Integer> v4 = new Vector<>(v1);

        /* -------------------- METHODS -------------------- */

        // 1. add()
        v1.add(10);
        v1.add(20);

        // 2. addElement()
        v1.addElement(30);

        // 3. insertElementAt()
        v1.insertElementAt(15, 1);

        // 4. get()
        System.out.println(v1.get(0));

        // 5. elementAt()
        System.out.println(v1.elementAt(1));

        // 6. set()
        v1.set(0, 100);

        // 7. remove()
        v1.remove((Integer) 15);

        // 8. removeElement()
        v1.removeElement(30);

        // 9. size()
        System.out.println(v1.size());

        // 10. capacity()
        System.out.println(v1.capacity());

        // 11. contains()
        System.out.println(v1.contains(20));

        // 12. indexOf()
        System.out.println(v1.indexOf(20));

        // 13. firstElement()
        System.out.println(v1.firstElement());

        // 14. lastElement()
        System.out.println(v1.lastElement());

        // 15. clear()
        v2.clear();

        // 16. isEmpty()
        System.out.println(v2.isEmpty());

        System.out.println(v1);
    }
}
