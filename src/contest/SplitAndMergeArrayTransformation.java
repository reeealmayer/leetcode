package contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SplitAndMergeArrayTransformation {
    // Представление состояния массива для хранения в Set
    static class State {
        int[] arr;
        int steps;

        State(int[] arr, int steps) {
            this.arr = arr;
            this.steps = steps;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) return false;
            return Arrays.equals(arr, ((State) obj).arr);
        }
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State start = new State(nums1, 0);
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (Arrays.equals(current.arr, nums2)) {
                return current.steps;
            }

            int n = current.arr.length;

            // Перебираем все подряд идущие подмассивы
            for (int L = 0; L < n; L++) {
                for (int R = L; R < n; R++) {
                    // Вырезаем подмассив
                    int[] sub = Arrays.copyOfRange(current.arr, L, R + 1);
                    int[] remaining = new int[n - sub.length];
                    int idx = 0;
                    for (int i = 0; i < n; i++) {
                        if (i < L || i > R) {
                            remaining[idx++] = current.arr[i];
                        }
                    }

                    // Вставляем подмассив в любое место оставшегося массива
                    for (int insertPos = 0; insertPos <= remaining.length; insertPos++) {
                        int[] next = new int[n];
                        // Скопировать префикс
                        System.arraycopy(remaining, 0, next, 0, insertPos);
                        // Вставить подмассив
                        System.arraycopy(sub, 0, next, insertPos, sub.length);
                        // Скопировать остаток
                        System.arraycopy(remaining, insertPos, next, insertPos + sub.length, remaining.length - insertPos);

                        State nextState = new State(next, current.steps + 1);
                        if (!visited.contains(nextState)) {
                            visited.add(nextState);
                            queue.add(nextState);
                        }
                    }
                }
            }
        }

        return -1; // Не должно случиться, если nums2 — перестановка nums1
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2,3,4,5};
        int[] nums2 = {5,4,3,2,1,1};

        int result = minOperations(nums1, nums2);
        System.out.println("Минимальное количество операций: " + result); // Должно быть 3
    }
}
