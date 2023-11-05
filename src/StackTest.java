public class StackTest {


    public static void main(String[] args) {
        Stack s1 = new Stack(10);

        s1.traverse();
        System.out.println("Push 19");
        s1.push(19);
        s1.traverse();
        System.out.println("Push 28");
        s1.push(28);
        s1.traverse();
        s1.pop();
        s1.peek();
        s1.traverse();
    }

}
