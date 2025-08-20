package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top !='[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid2("(())[]{}");
    }
}
