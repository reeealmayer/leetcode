package proselyte_course.module_1_3.lambdas_interfaces;

public class Tests {
    public static void main(String[] args) {
//        MyNumber myNumber = () -> 2.0;
//        System.out.println(myNumber.getValue());
//
//        myNumber = () -> Math.random() * 100;
//        System.out.println(myNumber.getValue());

        NumericTest isEven = (n) -> (n % 2 == 0);
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(11));

        NumericTest isNonNeg = (n) -> (n >= 0);
        System.out.println(isNonNeg.test(10));
        System.out.println(isNonNeg.test(-10));
    }
}
