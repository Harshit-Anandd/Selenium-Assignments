class StringOperations {

    public static void main(String[] args) {

        // Creating string objects
        String str = "  Hello Java World  ";
        String str2 = "Hello Java World";

        // Length of string
        System.out.println(str.length());

        // Checking if string is empty
        System.out.println(str.isEmpty());

        // Character at index 2
        System.out.println(str.charAt(2));

        // Comparing strings for equality
        System.out.println(str.equals(str2));

        // Lexicographical comparison
        System.out.println(str.compareTo(str2));

        // Checking substring presence
        System.out.println(str.contains("Java"));

        // Finding first occurrence index
        System.out.println(str.indexOf("o"));

        // Finding last occurrence index
        System.out.println(str.lastIndexOf("o"));

        // Checking prefix
        System.out.println(str.startsWith("  He"));

        // Checking suffix
        System.out.println(str.endsWith("ld  "));

        // Pattern matching
        System.out.println(str.matches(".*Java.*"));

        // Extracting substring
        System.out.println(str.substring(2, 7));

        // Converting to lowercase
        System.out.println(str.toLowerCase());

        // Removing leading and trailing spaces
        System.out.println(str.trim());

        // Replacing word
        System.out.println(str.replace("Java", "Python"));

        // Splitting string
        String[] parts = str.trim().split(" ");

        // Joining strings
        System.out.println(String.join("-", parts));

        // Converting integer to string
        int num = 10;
        System.out.println(String.valueOf(num));

        // StringBuffer usage (mutable)
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb);

        // StringBuilder usage (faster mutable)
        StringBuilder sbl = new StringBuilder("Java");
        sbl.append(" Programming");
        System.out.println(sbl);
    }
}