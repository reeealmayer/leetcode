package proselyte_course.module_1_3.lambdas_interfaces._3_generic;

public class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }
        return count;
    }
}
