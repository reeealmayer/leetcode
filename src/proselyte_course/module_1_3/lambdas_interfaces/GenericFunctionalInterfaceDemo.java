package proselyte_course.module_1_3.lambdas_interfaces;

public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (n) -> {
            StringBuilder result = new StringBuilder();
            for (int i = n.length() - 1; i >= 0; i--) {
                result.append(n.charAt(i));
            }

            return result.toString();
        };

        System.out.println(reverse.func("reverse"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println(factorial.func(6));

    }
}
