import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindSeqOfKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Храним пары (значение, индекс)
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedNums.add(new int[]{nums[i], i});
        }

        // Сортируем по убыванию значения
        indexedNums.sort((a, b) -> Integer.compare(b[0], a[0]));

        // Берём k самых больших
        List<int[]> topK = indexedNums.subList(0, k);

        // Сортируем обратно по индексу, чтобы сохранить порядок
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Заполняем результат
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
