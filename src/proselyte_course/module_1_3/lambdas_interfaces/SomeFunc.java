package proselyte_course.module_1_3.lambdas_interfaces;

@FunctionalInterface
public interface SomeFunc<T> {
    T func(T t);
}
