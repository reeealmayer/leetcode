package proselyte_course.module_1_3.lambdas_interfaces;

import java.util.function.Function;

public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = n -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println(factorial.apply(10));
    }
}
