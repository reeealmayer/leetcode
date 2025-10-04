package proselyte_course.module_1_3.lambdas_interfaces;

public class LambdasAsArgumentsDemo {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность java";
        String outStr;

        System.out.println(inStr);

        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println(outStr);

        outStr = stringOp((str) -> {
            StringBuilder result = new StringBuilder();
            for(char c: str.toCharArray()) {
                if (c != ' ') {
                    result.append(c);
                }
            }
            return result.toString();
        }, inStr);

        System.out.println(outStr);

        StringFunc reverse = (str) -> {
            String result = "";
            for (int j = str.length() - 1; j >= 0; j--) {
                result += str.charAt(j);
            }
            return result;
        };
        System.out.println(stringOp(reverse, "asd"));
    }
}
