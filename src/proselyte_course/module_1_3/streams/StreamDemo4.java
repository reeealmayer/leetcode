package proselyte_course.module_1_3.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        Stream<Double> sqrtRootStream = myList.stream()
                .map(Math::sqrt);

        Double productOfSqrRoots = sqrtRootStream.reduce(1.0, (a, b) -> a * b);

        System.out.println(productOfSqrRoots);

    }
}
