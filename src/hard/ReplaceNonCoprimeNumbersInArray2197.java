package hard;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoprimeNumbersInArray2197 {
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            stack.add(num);
            while (stack.size() >= 2) {
                int a = stack.getLast();
                int b = stack.get(stack.size() - 2);
                int gcd = gcd(a, b);
                if (gcd == 1) {
                    break;
                }

                int lcm = (int)((long) a / gcd * b);
                stack.removeLast();
                stack.set(stack.size() - 1, lcm);
            }
        }

        return stack;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(10, 12));
    }
}
