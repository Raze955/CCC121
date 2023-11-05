import java.util.Scanner;

public class Node {

    private int value;

    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Main{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the interger: ");
        int n = input.nextInt();

        Node start = new Node();
        Node current = start;

        for(int i = 1; i < n + 1; i++){
            Node new_node = new Node();
            new_node.setValue(i);
            current.setNext(new_node);
            current = new_node;
        }

        current.setNext(start.getNext());

        current = start.getNext();

        String output = "";

        for (int i = 0; i < n * 2; i++){
            output += current.getValue() + " ";
            current = current.getNext();
        }

        System.out.println(output);
    }
}
