package proselyte_course.module_1_3.lambdas_interfaces;

public class VarCapture {
    public static int MY_CONST = 10;
    public static void main(String[] args) {
        int num = 10;

        MyFunc myLambda = (n) -> {
            int v = num + n;
            int r = MY_CONST + 10;
//            num++;
            MY_CONST = 20;
            return v;
        };
        myLambda.func(10);
        System.out.println(MY_CONST);
//        num = 9;
    }
}
