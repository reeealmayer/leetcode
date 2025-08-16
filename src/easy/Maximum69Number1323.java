package easy;

public class Maximum69Number1323 {
    public static int maximum69Number(int num) {
        String s = String.valueOf(num);
        return Integer.parseInt(s.replaceFirst("6", "9"));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
}
