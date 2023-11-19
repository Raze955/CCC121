/*
NAME: Lluch, Josiah Raziel S.
        SUBJECT: CCC121
        BLOCK: IT2B

        HEADINGS

        Inputs:
        -infix expressions

        Outputs
        -stack pushing
        -stack popping
        -stack top element
        -stack peep/peek
        -stack isEmpty boolean
        -stack isFull boolean
        -postfix expression converted from infix


        process description:
        -Each input will be taken as parameters for the functions/methods
        that will perform each algorithm.
        -Each algorithm will process the input and will either return the
        newly processed data, or, if the return type is void, the result
        will be directly outputted.
        */

import java.util.Scanner;

public class MP3 {

    static Scanner input = new Scanner(System.in);

    private static int precedence(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    public static void main(String[] args) {

        Stack stack = new Stack(10);
        choose(stack);
    }

    static void choose(Stack stack) throws NumberFormatException {
        loop:
        while(true){
            System.out.println("Choose an operation");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Peek");
            System.out.println("5. Is Empty?");
            System.out.println("6. Is Full?");
            System.out.println("7. Convert to PostFix");
            System.out.println("8. Exit Program");
            System.out.println();

            System.out.print("Input: ");
            int choose = 0;
            try{
                choose = intInput();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            switch(choose){
                case 1 :
                    System.out.println("Enter the element that you want to push");
                    try{
                        stack.push(input.nextLine());
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2 :
                    stack.pop();
                    System.out.println("Element has been popped");
                    break;
                case 3 :
                    try{
                        System.out.println("The top element is \"" + stack.top() + "\"");
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4 :
                    System.out.println("Enter the index that you want to peek");
                    int index = intInput();
                    try{
                        System.out.println(stack.peek(index));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5 :
                    System.out.println("The stack is empty: " +stack.isEmpty());
                    break;
                case 6 :
                    System.out.println("The stack is full: " +stack.isFull());
                    break;
                case 7 :
                    System.out.print("Enter your infix expression: ");
                    String infixExpression = input.nextLine();
                    infixExpression = infixExpression.replaceAll("\\s", "");

                    String postfix = infixToPostfix(infixExpression);
                    System.out.println("Postfix Expression: " + postfix);
                    System.out.println("Result = " +getResult(postfix));
                    break;
                case 8 :
                    System.out.println("Terminating program");
                    break loop;
                default :
                    System.out.println("Input a number from 1 to 11");
            }
            System.out.println();
        }
    }

    public static String getResult(String expression){
        return "";
    }
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack(100);
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(Character.toString(c));
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && !stack.top().equals("(")) {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(Character.toString(c)) <= precedence(stack.top())) {
                    result.append(stack.pop());
                }
                stack.push(Character.toString(c));
            }
        }
        while (!stack.isEmpty()) {
            if (stack.top().equals("(")) {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }
        return result.toString();
    }

    static boolean isParsable(String value) throws NumberFormatException{
        try{
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException NFE){
            return false;
        }
    }

    static int intInput() throws NumberFormatException{

        String temp = input.nextLine();
        if(!isParsable(temp))throw new NumberFormatException("\n!!You inputted a STRING, please input an integer!!");
        else return Integer.parseInt(temp);
    }

}