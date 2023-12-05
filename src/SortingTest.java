import java.util.Random;
import java.util.Scanner;

public class SortingTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n\nThis program will run 6 different sorting algorithms simultaneously using a randomised array of integers from 0 to 1000 with size n. \nObserve how the runtimes will differ as n gets larger");
        System.out.print("\ninput n = ");
        int n = input.nextInt();

        int []random = randNumList(n);


        //System.out.println("Original list");
        //printList(random);
        //System.out.println("sorted list");
/*        int[] insertionSort = Sort.insertion(random);
//        printList(insertionSort);
//        printList(random);
        int[] mergeSort = Sort.merge(random);
//        printList(mergeSort);
//        printList(random);
        int[] selectionSort = Sort.selection(random);
//        printList(selectionSort);
//        printList(random);
        int[] quickSort = Sort.quick(random);
//        printList(quickSort);
//        printList(random);
        int[] heapSort = Sort.heap(random);
//        printList(heapSort);
//        printList(random);
        int[] radixSort = Sort.radix(random);
//        printList(radixSort);
//        printList(random);*/

        for(int i = 1; i < 8; i++){
            thread(i, random);
        }

    }

    public static int[] randNumList(int size){
        Random rand = new Random();
        int[] randList = new int[size];
        for(int i = 0; i < size; i++){
            randList[i] = rand.nextInt(1000);
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

    static void thread(int choice, int[] list){
        class Execute extends Thread{
            @Override
            public void run(){
                long time1;
                long time2;

                switch (choice){
                    case 1:
                        time1 = System.currentTimeMillis();
                        Sort.insertion(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: INSERTION SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 2:
                        time1 = System.currentTimeMillis();
                        Sort.merge(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: MERGE SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 3:
                        time1 = System.currentTimeMillis();
                        Sort.selection(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: SELECTION SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 4:
                        time1 = System.currentTimeMillis();
                        Sort.quick(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: QUICK SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 5:
                        time1 = System.currentTimeMillis();
                        Sort.heap(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: HEAP SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 6:
                        time1 = System.currentTimeMillis();
                        Sort.radix(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: RADIX SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                    case 7:
                        time1 = System.currentTimeMillis();
                        Sort.bubble(list);
                        time2 = System.currentTimeMillis();
                        System.out.println("Finished: BUBBLE SORT. Runtime: " +(time2-time1) +"ms");
                        break;
                }
            }
        }
        Execute exe = new Execute();
        exe.start();
    }
}
