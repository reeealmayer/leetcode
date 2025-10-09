package proselyte_course.module_1_3.streams;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        Optional<Integer> product = myList
                .stream()
                .reduce((a, b) -> a + b);

        System.out.println(product.get());

        Integer product2 = myList.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(product2);

        Integer reduce = myList.stream()
                .reduce(1, (a, b) -> {
                    if (b % 2 == 0) {
                        return a * b;
                    } else {
                        return a;
                    }
                });

        System.out.println(reduce);
    }
}
