import java.util.Arrays;

public class DivideStringIntoGroupsOfK {
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k;
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            StringBuilder group = new StringBuilder(s.substring(start, end));

            while (group.length() < k) {
                group.append(fill);
            }
            result[i] = group.toString();
        }
        return result;
    }


    public static String[] mySolution(String s, int k, char fill) {
        int length = s.length();
        int numberOfK = length / k;
        int resultLength = numberOfK;
        if (length % k > 0) {
            resultLength++;
        }
        String[] result = new String[resultLength];
        int counter = 0;

        int i;
        for (i = 0; i < numberOfK * k; i += k) {
            result[counter] = s.substring(i, k + i);
            counter++;
        }

        if (length - i > 0) {
            result[counter] = s.substring(i, length);
            for (int j = result[counter].length(); j < k; j++) {
                result[counter] += fill;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
}
