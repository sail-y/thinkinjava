package c08;//: holding/StackTest.java

import net.mindview.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");

        stack.push("U");
        stack.push("n");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("e");
        stack.push("r");
        stack.push("t");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("a");
        System.out.println(stack.pop());
        stack.push("n");
        stack.push("t");
        stack.push("y");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(stack.pop());
        stack.push("r");
        stack.push("u");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("r");
        stack.push("e");
        stack.push("s");
    }
} /* Output:
fleas has dog My
*///:~
