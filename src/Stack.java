class Stack {
    Stack(int n){
        this.a = new String[n];
    }
    private final String[] a;
    private int top=-1;
    void push(String c) throws IndexOutOfBoundsException{
        if(top+1 == getSize()) throw new IndexOutOfBoundsException("Stack full, no room to push, size=100");
        a[++top]= c;
    }
    String pop() throws IndexOutOfBoundsException{
        if(isEmpty()) throw new IndexOutOfBoundsException("The stack is empty!");
        return a[top--];
    }
    boolean isEmpty() {
        return top == -1;
    }
    boolean isFull() {
        return top == getSize();
    }
    String top() throws IndexOutOfBoundsException{
        if(isEmpty()) throw new IndexOutOfBoundsException("The stack is empty!");
        return a[top];
    }

    String peek(int index) throws IndexOutOfBoundsException{
        if(isEmpty()) throw new IndexOutOfBoundsException("The stack is empty!");
        return a[index];
    }

    public int getSize(){
        return a.length;
    }
}     