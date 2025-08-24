package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();

        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                digits.push(Integer.parseInt(token));
            } else {
                int val1 = digits.pop();
                int val2 = digits.pop();
                int tempo = 0;
                switch (token) {
                    case "+":
                        tempo = val2 + val1;
                        break;
                    case "-":
                        tempo = val2 - val1; // порядок важен!
                        break;
                    case "*":
                        tempo = val2 * val1;
                        break;
                    case "/":
                        tempo = val2 / val1; // порядок важен!
                        break;
                }
                digits.push(tempo);
            }
        }

        return digits.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
