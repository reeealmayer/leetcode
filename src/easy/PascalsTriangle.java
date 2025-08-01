package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> outerList = new ArrayList<>();
        List<Integer> firstList = List.of(1);
        List<Integer> secondList = List.of(1, 1);
        outerList.add(firstList);
        if (numRows == 1) {
            return outerList;
        }
        outerList.add(secondList);
        if (numRows == 2) {
            return outerList;
        }

        List<Integer> tempo = new ArrayList<>();
        for (int i = 1; i < numRows - 1; i++) {
            List<Integer> integers = outerList.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                if (j == 0) {
                    tempo.add(integers.get(j));
                }
                tempo.add(integers.get(j) + integers.get(j + 1));
            }
            tempo.add(integers.get(integers.size() - 1));
            outerList.add(tempo);
            tempo = new ArrayList<>();
        }
        return outerList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
