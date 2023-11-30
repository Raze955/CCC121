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
    static Stack postfix;

    private static int precedence(String c) {
        switch (c) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
            case "^": return 3;
            default: return -1;
        }
    }

    public static void main(String[] args) throws Exception {

        choose();
    }

    static void choose() throws Exception {
        loop:
        while(true){
            System.out.print("Enter your infix expression: ");
            String infixExpression = input.nextLine();
            infixExpression = infixExpression.replaceAll("\\s", "");

            //try{
                postfix = infixToPostfix(infixExpression);

                System.out.println("Postfix expression: ");
                for(int i = 0; i < postfix.getSize(); i++){
                    if(postfix.peek(i) == null) continue;
                    System.out.println(postfix.peek(i));
                }

                System.out.println();
                System.out.println("Result = " + evaluatePostfix(postfix));

           // }catch(Exception e){
            //    System.out.println(e.getMessage());
            //}

            System.out.println();
            loop2:
            while(true){
                System.out.println("Do you want to try again?(Type 1 for yes, type 2 for no)");
                int choice = intInput();
                switch (choice) {
                    case 1:
                        break loop2;
                    case 2:
                        break loop;
                    default:
                        System.out.println("Invalid input, try again");
                }
            }
        }
        System.out.println("Terminating program");
    }

    public static String addMultiply(String infix){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < infix.length(); i++){
            str.append(infix.charAt(i));
            if(i != infix.length()-1 && Character.isDigit(infix.charAt(i)) && infix.charAt(i+1) == '(') str.append("*");
        }
        return str.toString();
    }

    public static double evaluatePostfix(Stack expression) {
        Stack stack = new Stack(expression.getSize());

        for (int i = 0; i < expression.getSize(); i++) {
            String s = expression.peek(i);
            if (isParsable(s)) {
                stack.push(s);
            } else if(expression.peek(i) != null){
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());

                switch (s.charAt(0)) {
                    case '+':
                        stack.push(Double.toString(operand1 + operand2));
                        break;
                    case '-':
                        stack.push(Double.toString(operand1 - operand2));
                        break;
                    case '*':
                        stack.push(Double.toString(operand1 * operand2));
                        break;
                    case '/':
                        stack.push(Double.toString(operand1 / operand2));
                        break;
                    case '^':
                        stack.push(Double.toString(Math.pow(operand1 , operand2)));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + s);
                }
            }
        }

        return Double.parseDouble(stack.pop());
    }

    public static Stack infixToPostfix(String expression) throws Exception {
        String infix = addMultiply(expression);
        Stack postfix = new Stack(infix.length());
        Stack stack = new Stack(100);
        for (int i = 0; i < infix.length(); i++) {
            if (Character.isDigit(infix.charAt(i))) { //this chunk of code is for pushing multidigit numbers into the stack
                if(i != infix.length()-1 && Character.isDigit(infix.charAt(i+1))) continue;
                for(int j = i; j >= 0; j--){
                    if( j == 0 || !Character.isDigit(infix.charAt(j-1))){
                        postfix.push(infix.substring(j, i+1));
                        break;
                    }
                }
            } else if (infix.charAt(i) == '(') { //this chunk of code is for pushing an opening parenthesis into the stack
                //if(Character.isDigit(expression.charAt(i-1)) || expression.charAt(i-1) == '(' || expression.charAt(i-1) == ')') stack.push("*");
                stack.push(Character.toString(infix.charAt(i)));
            } else if (infix.charAt(i) == ')') { //this chunk of code is for pushing a closing parenthesis into the stack
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    postfix.push(stack.pop());
                }
                if (!stack.isEmpty() && !stack.top().equals("(")) {
                    throw new Exception("Invalid Expression");
                } else {
                    stack.pop();
                }
            } else { //this chunk of code is for the operator precedence
                while (!stack.isEmpty() && precedence(Character.toString(infix.charAt(i))) <= precedence(stack.top())) {
                    postfix.push(stack.pop());
                }
                stack.push(Character.toString(infix.charAt(i)));
            }
        }
        while (!stack.isEmpty()) {
            if (stack.top().equals("(")) {
                throw new Exception("Invalid Expression");
            }
            postfix.push(stack.pop());
        }
        return postfix;
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