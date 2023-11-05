public class Stack {

    private int stack[];
    private int front;
    private int rear;
    public int temp;
    Stack(int size){
        stack = new int[size];
        setEmptyPointer();
    }

    Stack(int array[]){
        stack = array;
        if(isEmpty()) setEmptyPointer();
        else{
            front = 0;
            for(int i = 0; i < getLength(); i++){
                if(stack[i] == 0) {
                    rear = i - 1;
                    break;
                }
                else rear = getLength()-1;
            }
        }
    }

    private int getLength(){
        return stack.length;
    }

    private void setEmptyPointer(){
        front = -1;
        rear = -1;
    }

    public void traverse(){
        System.out.print("{");
        /*for(int i = 0; i < getLength()-1; i++){
            if(i != getLength()-1 && stack[i] != 0 && stack[i+1] != 0) System.out.print(stack[i] +", ");
            else if(stack[i] != 0 && stack[i+1] == 0)System.out.print(stack[i]);
        }*/
        for(int j : stack){
            System.out.print(j +" ");
        }
        System.out.print("}\n");
    }

    public void push(int value){
        if(!(isFull() || isEmpty())){
            rear += 1;
            stack[rear] = value;
        }
        else if(isEmpty()){
            front++;
            rear++;
            stack[rear] = value;
        }
        else System.out.println("The stack if full! Pop an element before pushing a new element");
    }

    public void pop(){
        if(!isEmpty()){
            setTemp(stack[rear]);
            stack[rear] = 0;
            if(rear == 0) front--;
            rear--;
            System.out.println("Pop " +temp);
        }
        else System.out.println("The stack is empty! Push an element before popping");
    }

    public void peek(){
        if(isEmpty()) System.out.println("The stack is empty! Push an element before peeking");
        System.out.println("Peek " +stack[rear]);
    }

    public boolean isEmpty(){
        for (int j : stack) {
            if (j != 0) return false;
        }
        return true;
    }

    public boolean isFull(){
        for (int j : stack) {
            if (j == 0) return false;
        }
        return true;
    }

    private void setTemp(int value){
        temp = value;
    }
}
