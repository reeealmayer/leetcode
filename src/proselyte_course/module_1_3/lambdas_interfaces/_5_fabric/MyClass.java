package proselyte_course.module_1_3.lambdas_interfaces._5_fabric;

public class MyClass<T> {
    private T val;

    public MyClass(T val) {
        this.val = val;
    }

    public MyClass() {
    }

    public T getVal() {
        return val;
    }
}
