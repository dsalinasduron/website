import java.util.Stack;

public class BinaryChecker
{
    public static void main(String[] args) {
        Stack<String> stack = new java.util.Stack<String>();
        Stack<Character> stack1 = new java.util.Stack<Character>();
        Stack<Character> stack2 = new java.util.Stack<Character>();
        String result;

        int number = Integer.parseInt(args[0]);
        boolean flag = true;

        if (number != 0) {
        while (number != 0) {
            if ( (number & 1) == 0)
                stack.push("0");
            else
                stack.push("1");

            number = number >> 1;
        }

        result = stack.pop();
        while (!stack.isEmpty())
            result += stack.pop();

        System.out.println(result);

        for (int i = 0; i < result.length(); i++)
            stack1.push(result.charAt(i));
        for (int i = result.length()-1; i >= 0; i--)
            stack2.push(result.charAt(i));


        while (flag && !stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                System.out.println("Nope");
                flag = false;
            }
        }
        }

        if (flag)
            System.out.println("yup");
    }
}

