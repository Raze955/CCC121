import java.util.Random;

public class SortingTest {

    public static void main(String[] args) {
        int []random = randNumList(10);

        System.out.println("Original list");
        printList(random);
        System.out.println("sorted list");
        //Sort.insertion(random);
        //Sort.merge(random);
        //Sort.selection(random);
        //Sort.quick(random);
        //Sort.heap(random);
        //Sort.radix(random);
        printList(random);

    }

    public static int[] randNumList(int size){
        Random rand = new Random();
        int[] randList = new int[size];
        for(int i = 0; i < size; i++){
            randList[i] = rand.nextInt(100);
        }
        return randList;
    }

    static void printList(int[] list){
        System.out.print("{");
        for(int i = 0; i < list.length; i++){
            if(i == list.length-1){
                System.out.print(list[i]);
                break;
            }
            if(i != list.length-1 && list[i] != 0 && list[i+1] != 0) System.out.print(list[i] +", ");
            else if(list[i] != 0 && list[i+1] == 0)System.out.print(list[i]);
        }
        System.out.print("}\n");
    }
}
