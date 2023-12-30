package data_structures.list;

/**
 *      Otherwise known as a "Simple List", the template for the other variations of a list
 */
public class List{

    private Node head, tail, current;

    /**
     *      This constructor is used to convert an array into a list
     * @param array is the reference to the array that the user want to convert into a List
     */
    public <T> List(T[] array){
        head = new Node();
        head.setValue(array[0]);
        current = head;
        tail = head;

        for(int i = 1; i < array.length; i++){
            append(array[i]);
        }

        current = head;
    }

    /**
     *      append method, used for adding an element to the list
     */
    public <T> void append(T value){
        if(head == null){
            head = new Node();
            head.setValue(value);
            current = head;
        }

        else{
            Node new_node = new Node();
            current.setNext(new_node);
            current = new_node;
            current.setValue(value);
        }

        tail = current;
    }

    public void traverse(){
        System.out.print("{");
        while(true){
            if(current != tail) System.out.print(current.getValue() +", ");
            else System.out.print(current.getValue());

            if(current == tail) break;
            current = current.getNext();
        }
        System.out.print("}\n");
    }
}
