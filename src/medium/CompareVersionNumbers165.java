package medium;

public class CompareVersionNumbers165 {
    public static int compareVersion(String version1, String version2) {
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");

        int n = Math.max(num1.length, num2.length);

        for (int i = 0; i < n; i++) {
            int digit1 = i < num1.length ? Integer.parseInt(num1[i]) : 0;
            int digit2 = i < num2.length ? Integer.parseInt(num2[i]) : 0;

            if (digit1 > digit2) {
                return 1;
            } else if (digit2 > digit1) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.0.0.0", "1.0.0"));
    }
}
