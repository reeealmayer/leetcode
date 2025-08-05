package easy;

public class FruitsIntoBasketsII3477 {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int length = fruits.length;
        int result = length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = -1;
                    result--;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{3,6,1}, new int[]{6,4,7}));
    }
}
