/*
NAME: Lluch, Josiah Raziel S.
SUBJECT: CCC121
BLOCK: IT2B

     HEADINGS

        Inputs:
            -distinct positive integers

        Outputs
            -array traversal
            -element insertion
            -element deletion
            -element search
            -element update
            -check if array is full
            -check if array is empty
            -minimum(smallest) element
            -elements smaller than given value
            -compare adjacent elements


            process description:
            -Each input will be taken as parameters for the functions/methods
            that will perform each algorithm.
            -Each algorithm will process the input and will either return the
            newly processed data, or, if the return type is void, the result
            will be directly outputted.
*/

import java.util.*;

public class Main_MP2 {
    static MP2 mp2; //The object is declared global so that the methods within this class can access it.
    static Scanner input = new Scanner(System.in); //The object is declared global so that the methods within this class can access it.

    public static void main(String[] args) {

        mp2 = new MP2(initializeArray()); //using the initializeArray() method to initialize an array and return it to the MP2 class constructor.

        while(true){
            try {
                choose(mp2);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void choose(MP2 m) throws NumberFormatException {

        System.out.print("Your array: ");
        m.traverse();
        System.out.println();
        loop:
        while(true){
            System.out.println("Choose an operation");
            System.out.println("1. Traverse");
            System.out.println("2. Insertion");
            System.out.println("3. Deletion");
            System.out.println("4. Search");
            System.out.println("5. Update");
            System.out.println("6. Empty");
            System.out.println("7. Full");
            System.out.println("8. Find Minimum");
            System.out.println("9. Find Elements lesser than given value");
            System.out.println("10. Compare adjacent elements");
            System.out.println("11. Exit");
            System.out.println();

            System.out.print("Input: ");
            int choose = intInput();
            switch(choose){
                case 1 : m.traverse();
                    break;
                case 2 : insertion();
                    break;
                case 3 :
                    while(true){
                        try{
                            System.out.print("Do you want to delete based on index or based on value?(type 1 for index, 2 for value): ");
                            int temp = intInput();
                            if(temp == 1) {
                                System.out.print("Input the index that you want to delete(0 to " +(mp2.getCurrentSize()-1) + "): ");
                                m.indexDelete(deletionIndexInput());
                                break;
                            }
                            else if(temp == 2){
                                while(true){
                                    try {
                                        System.out.print("Input the value that you want to delete: ");
                                        m.valueDelete(positiveIntInput());
                                        break;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                            }
                            else throw new Exception("Invalid input, input either 1 or 2");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4 : search();
                    break;
                case 5 :
                    System.out.print("Which index do you want to update?: ");
                    int temp = indexInput();
                    while(true){
                        try{
                            System.out.print("Input the new value: ");
                            int value = positiveIntInput();
                            if (m.isDistinct(value)) {
                                m.update(temp, value);
                                break;
                            }
                            else throw new Exception("\n!!The number is NOT DISTINCT, please enter a distinct value!!");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 6 : System.out.println("The array is empty: " +Boolean.toString(m.isEmpty()).toUpperCase()); //to print the boolean in upper case
                    break;
                case 7 : System.out.println("The array is full: " +Boolean.toString(m.isFull()).toUpperCase()); //to print the boolean in upper case
                    break;
                case 8 : System.out.println("The smallest number in the array is: " +m.findMin());
                    break;
                case 9 : while(true){
                    try {
                        System.out.println("Input the value that you want to evaluate");
                        m.findSmaller(positiveIntInput());
                        break;
                    }catch (Exception e) {
                        System.out.println(e.getMessage() + "Try again");
                    }
                }
                    break;
                case 10: System.out.print("input the index that you want to compare: ");
                    int index = indexInput();
                    boolean validIndex = index < (m.getLength() - 1);
                    if(!validIndex) System.out.println("Cannot compare, you chose the last index");
                    else {
                        if(m.getElement(index + 1) == 0 || m.getElement(index) == 0) System.out.println("!!Invalid comparison!! (0 to " +(m.getCurrentSize()-2) +")");
                        else System.out.print(Boolean.toString(m.compareAdjacent(index)).toUpperCase() +"\n"); //to print the boolean in upper case
                    }
                    break;

                case 11: System.out.println("Terminating program");
                    break loop;
                default :
                    System.out.println("Input a number from 1 to 11");
            }
            if(choose != 1) m.traverse(); //since option 1 is traverse, the code will not perform this line to avoid duplicate printing.
            System.out.println();
        }
    }
    private static boolean isDistinct(int element, int index, int[] array){ //helper method
        for(int i = 0; i < index; i++){
            if (element == array[i]) return false;
        }
        return true;
    }
    static int[] initializeArray() {
        int[] array = new int[10]; //setting the maximum length to 10 by default

        try{
            System.out.print("How many elements do you want to input? ");
            int n = positiveIntInput(); //use the intInput method for error trapping
            if(n > 0 && n < 11) {
                System.out.println("Enter the elements of your array");

                for(int i = 0; i < n; i++) {

                    while(true){
                        try{
                            System.out.print("Element " +(i+1) +": ");
                            int tempElement = positiveIntInput();
                            if(isDistinct(tempElement, i, array)){
                                array[i] = tempElement; //using the error trapping intInput() method
                                System.out.println(); //create a space before the next element
                                break;
                            }
                            else throw new Exception("Please enter a DISTINCT POSITIVE integer");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                }
                return array;
            }
            else throw new IndexOutOfBoundsException("Please input a positive integer less than 11\n"); //if the user chooses more than 10 then it will throw an IndexOutOfBoundsException

        } catch(Exception e){
            System.out.println(e.getMessage() +"\n"); //display an error message
            return initializeArray(); //rerun the whole method through method recursion
        }
    }
    static int positiveIntInput() throws Exception{
        int temp = intInput();
        if (temp < 1) throw new Exception("\n!!The number must be positive!!"); //check if the input is positive
        return temp; //return the value of temp
    }
    static int intInput() throws NumberFormatException{

        String temp = input.nextLine();
        if(!isParsable(temp))throw new NumberFormatException("\n!!You inputted a STRING, please input an integer!!");
        else return Integer.parseInt(temp);
    }
    static int indexInput(){
        try{
            int temp = intInput(); //use the intInput() method to get a positive integer value
            if(temp > mp2.getCurrentSize() || temp < 0) throw new Exception("\n!!INVALID INDEX!!"); //if the input is less than the max size or less than 1, throw an exception
            else return temp; //if the input is valid, return the input
        }
        catch (Exception e){
            System.out.print(e.getMessage() +"\ninput another index from 0 to " +mp2.getCurrentSize() +": ");
            return indexInput(); //repeat the input process until the input is valid.
        }
    }
    static int deletionIndexInput(){
        try{
            int temp = intInput(); //use the intInput() method to get a positive integer value
            if(temp >= mp2.getCurrentSize() || temp < 0) throw new Exception("\n!!INVALID INDEX!!"); //if the input is less than the max size or less than 1, throw an exception
            else return temp; //if the input is valid, return the input
        }
        catch (Exception e){
            System.out.print(e.getMessage() +"\ninput another index from 0 to " +(mp2.getCurrentSize()-1) +": ");
            return deletionIndexInput(); //repeat the input process until the input is valid.
        }
    }
    static void insertion(){
        if(!mp2.isFull()){
            int index;
            while(true){
                try {
                    System.out.print("Input the index that you want to insert(0 to " + mp2.getCurrentSize() + "): ");
                    index = indexInput();
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            while(true){
                try{
                    System.out.print("Input the value that you want to insert: ");
                    int value = positiveIntInput();
                    if (!mp2.isDistinct(value)) throw new Exception("\n!!The number is NOT DISTINCT, please enter a distinct value!!");
                    else {
                        mp2.insertion(index, value);
                        break;
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    static void search(){
        try{
            System.out.println("do you want to search an index or a value?(type 1 for index, type 2 for value)");
            int choose = positiveIntInput();
            if(choose == 1) {
                while(true){
                    try {
                        System.out.print("Enter the index that you want to search(0 to " +(mp2.getCurrentSize()-1) +"): ");
                        mp2.searchIndex(deletionIndexInput());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if(choose == 2) {
                while(true){
                    try {
                        System.out.print("Enter the value that you want to search: ");
                        mp2.searchValue(positiveIntInput());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else throw new Exception("\n!!invalid input, try again!!");
        } catch (Exception e){
            System.out.println(e.getMessage());
            search();
        }
        System.out.println();
    }
    static boolean isParsable(String value) throws NumberFormatException{
        try{
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException NFE){
            return false;
        }
    }
}
class MP2{
    private final int[] array;
    private final int maxSize;
    private int currentSize;
    MP2(int[] array){
        this.array = array;
        maxSize = array.length;
        currentSize = setCurrentSize();
    }
    public void traverse(){
        System.out.print("{");
        for(int i = 0; i < getLength(); i++){
            if(i != getLength()-1 && array[i] != 0 && array[i+1] != 0) System.out.print(array[i] +", ");
            else if(array[i] != 0 && array[i+1] == 0)System.out.print(array[i]);
        }
        System.out.print("}\n");
    }
    public void insertion(int index, int value){

        //index -= 1;
        if(!isFull()){
            for(int i = getLength()-2; i >= index; i--){
                array[i+1] = array[i];
            }
            array[index] = value;
            currentSize = setCurrentSize();
        }
        else System.out.println("The array is full, you cannot insert a value");
    }
    public void indexDelete(int index){
        for (int i = index; i < getLength()-1; i++){
            array[i] = array[i+1];
        }
        array[getLength()-1] = 0;
        currentSize = setCurrentSize();
    }
    public void valueDelete(int value){
        for (int i = 0; i < getLength()-1; i++){
            if(array[i] == value) {
                indexDelete(i);
                currentSize = setCurrentSize();
                return;
            }
        }
        System.out.println("\nThat value is not found in the array");
    }
    public void searchIndex(int index){
        //index -= 1;
        if(!(index < getLength())) throw new IndexOutOfBoundsException();
        for(int i = 0; i < getLength(); i++){
            String element = (array[i] == 0)? "NULL" : Integer.toString(array[i]); //The string will be "null" if the element is 0, else it will be the element itself
            if (i == index) {
                System.out.println("The value in that index is " +element);
                return;
            }

        }
        System.out.println("There are no matching elements"); //This will be printed if there are no matching elements
    }
    public void searchValue(int value){ //this method is used for searching in the array using the given value
        for(int i = 0; i < getLength(); i++) {
            if (array[i] == value) {
                System.out.println("That value exists at index " +(i));
                return;
            }
        }
        System.out.println("Value not found"); //This will be printed if there are no matching elements
    }
    public void update(int index, int value){
        if(isDistinct(value)){
            //index -= 1;
            array[index] = value;
            currentSize = setCurrentSize();
        }
        else System.out.println("Please insert a DISTINCT POSITIVE integer");
    }
    public boolean isEmpty(){
        for (int j : array) {
            if (j != 0) return false;
        }
        return true;
    }
    public boolean isFull(){
        for (int j : array) {
            if (j == 0) return false;
        }
        return true;
    }
    public int findMin(){
        int min = array[0];
        for (int j : array) {
            if (j == 0) continue;
            if (j < min) min = j;
        }
        return min;
    }
    public void findSmaller(int num){

        System.out.print("The elements that are lesser than " +num +" are the following: {");
        for (int i = 0; i < getLength(); i++) {
            if (array[i] == 0) break;
            else if (array[i] < num && array[i+1] != 0) System.out.print(array[i] +", ");
            else if (array[i] < num && array[i+1] == 0) System.out.print(array[i]);


        }
        System.out.print("}\n");
    }
    public boolean compareAdjacent(int index){
        //index -= 1;
        System.out.print("Is " +array[index] +" < " +array[index + 1] +"? ");
        if(index < 9) return array[index] < array[index + 1];
        else return false;
    }
    public boolean isDistinct(int element){
        for(int i = 0; i < getLength()-1; i++){
            if (element == array[i]) return false;
        }
        return true;
    }
    public int getLength(){
        return array.length;
    }
    public int getElement(int index){
        return array[index];
    }
    public int setCurrentSize(){

        for(int i = 0; i < getLength(); i++){
            if(i != 9){
                if(array[i+1] == 0) return (i+1);
                else if(array[0] == 0) return 1;
            }else return 10;

        }
        return maxSize;
    }
    public int getCurrentSize(){

        return currentSize;
    }
}

