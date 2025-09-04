package easy;

public class FindClosestPerson3516 {
    public static int findClosest(int x, int y, int z) {
        int firstPerson = Math.abs(z - x);
        int secondPerson = Math.abs(z - y);
        if (firstPerson > secondPerson) {
            return 2;
        } else if (secondPerson > firstPerson) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
