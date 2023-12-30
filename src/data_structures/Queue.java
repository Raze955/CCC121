package data_structures;

public class Queue {

    private final int[] queue;
    private int front;
    private int rear;
    public int temp;
    Queue(int size){
        queue = new int[size];
        setEmptyPointer();
        int size1 = size - 1;
    }

    private int getLength(){
        return queue.length;
    }

    private void setEmptyPointer(){
        front = -1;
        rear = -1;
    }

    public void push(int value) throws Exception{
        if(!isFull()){
            queue[rear] = value;
            rear++;
        } else if (isEmpty()) {
            front = 0; rear = 0;
            queue[rear] = value;
        }
        else throw new Exception("The queue is full! empty the stack before pushing");
    }

    public void pop() throws Exception{
        setTemp(queue[front]);
        queue[front] = 0;
        front++;
        if(isEmpty()) setEmptyPointer();
    }

    public int peek() throws Exception{
        return queue[front];
    }

    public boolean isEmpty(){
        for (int j : queue) {
            if (j != 0) return false;
        }
        return true;
    }

    public boolean isFull(){
        for (int j : queue) {
            if (j == 0) return false;
        }
        return true;
    }

    private void setTemp(int value){
        temp = value;
    }
}
