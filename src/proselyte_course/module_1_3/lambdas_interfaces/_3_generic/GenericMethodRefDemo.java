package proselyte_course.module_1_3.lambdas_interfaces._3_generic;

public class GenericMethodRefDemo {
    static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"a", "b", "c", "a"};

        System.out.println(myOp(MyArrayOps::<Integer>countMatching, vals, 4));
        System.out.println(myOp(MyArrayOps::countMatching, vals, 4));
        System.out.println(myOp(MyArrayOps::countMatching, strs, "a"));
    }
}
