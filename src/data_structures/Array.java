package data_structures;
public class Array{
    private final int[] array;
    private final int maxSize;
    private int currentSize;
    public Array(int[] array){
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
    public void searchValue(int value){ //this method is used for searching in the array using thevgiven value
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