package proselyte_course.module_1_3.lambdas_interfaces;

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = n -> {
            StringBuilder result = new StringBuilder();
            for (int i = n.length() - 1; i >= 0; i--) {
                result.append(n.charAt(i));
            }

            return result.toString();
        };

        System.out.println(reverse.func("asdfghj"));
    }
}
