package proselyte_course.module_1_3.lambdas_interfaces;

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println(factorial.func(5));
    }
}
