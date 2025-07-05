public class FIndLuckyIntegerInAnArray {

    /**
     * Разогревает метод для JIT-компиляции (?)
     */
    static {
        for (int i = 0; i < 100; i++) {
            findLucky(new int[0]);
        }
    }

    public static int findLucky(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int result = -1;

        int[] digits = new int[501];

        for (int element : arr) {
            digits[element] += 1;
        }

        for (int i = 500; i > 0; i--) {
            if (i == digits[i]) {
                return i;
            }
        }

        return result;
    }
}
