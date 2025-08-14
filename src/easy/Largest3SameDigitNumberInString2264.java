package easy;

public class Largest3SameDigitNumberInString2264 {
    public static String largestGoodInteger(String num) {
        String result = "";
        int largest = -1;
        for (int i = 0; i <= 9; i++) {
            String tempo = i + "" + i + "" + i;
            if (num.contains(tempo) && i > largest) {
                result = tempo;
                largest = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }
}
