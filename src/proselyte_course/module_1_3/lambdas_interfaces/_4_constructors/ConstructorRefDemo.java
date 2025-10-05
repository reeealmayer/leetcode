package proselyte_course.module_1_3.lambdas_interfaces._4_constructors;

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc myClassCons = MyClass::new;

        MyClass mc = myClassCons.func(10);

        System.out.println(mc.getVal());
    }
}
