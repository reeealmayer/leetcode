package proselyte_course.module_1_3.lambdas_interfaces;

@FunctionalInterface
public interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}
