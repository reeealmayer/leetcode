package proselyte_course.module_1_3.streams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("исходный список " + myList);

        Stream<Integer> myStream = myList.stream();

        Optional<Integer> maxVal = myStream.max(Integer::compare);

        System.out.println(maxVal.get());

        Stream<Integer> sortedStream = myList.stream().sorted();

        sortedStream.forEach(System.out::println);


        myList.stream()
                .sorted()
                .filter(n -> n % 2 == 1)
                .forEach(System.out::println);

        myList.stream()
                .filter(n -> n % 2 == 1)
                .filter(n -> n > 5)
                .forEach(System.out::println);
    }
}
