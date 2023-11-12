import java.util.NoSuchElementException;

public class TestSLList {
    public static void main(String[] args) {
        SLList list = new SLList();

        // Adding elements to the list
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("B");
        list.addLast("D");
        list.addLast("E");
        list.addLast("B");

        // Testing the methods
        System.out.println("List: " + listToString(list));
        try {
            System.out.println("First element: " + list.getFirst());
            System.out.println("Last element: " + list.getLast());
            System.out.println("Deleted last element: " + list.deleteLast());
            System.out.println("List after deleting last element: " + listToString(list));
            System.out.println("Size of the list: " + list.size());
            System.out.println("Last index of 'B': " + list.lastIndexOf("B"));
            System.out.println("First index of 'B': " + list.firstIndexOf("B"));

            list.deleteAll("B");
            System.out.println("List after deleting all occurrences of 'B': " + listToString(list));
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Testing with an empty list
        SLList emptyList = new SLList();
        try {
            emptyList.getFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            emptyList.getLast();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            emptyList.deleteLast();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            emptyList.deleteAll("A");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String listToString(SLList list) {
        StringBuilder sb = new StringBuilder();
        SLList.SLLNode current = list.head;
        while (current != null) {
            sb.append(current.info).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}