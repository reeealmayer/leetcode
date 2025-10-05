package proselyte_course.module_1_3.lambdas_interfaces._5_fabric;

public class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc<R,T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;

        MyClass<Double> mc = myClassFactory(myClassCons, 100.1);

        System.out.println(mc.getVal());

        MyFunc<MyClass2, String> myClass2Cons = MyClass2::new;
        MyClass2 myc2 = myClassFactory(myClass2Cons, "new string");
        System.out.println(myc2.getStr());
    }
}
