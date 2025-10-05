package proselyte_course.module_1_3.lambdas_interfaces;

public class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println(inStr);
        System.out.println(outStr);

        MyStringOps myStringOps = new MyStringOps();
        inStr = "asdasd";
        outStr = stringOp(myStringOps::strReverse2, inStr);
        System.out.println(inStr);
        System.out.println(outStr);
    }
}
