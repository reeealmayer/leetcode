package contest;

public class EarliestTimeToFinishOneTask {
    public static int earliestTime(int[][] tasks) {
        int min = tasks[0][0] + tasks[0][1];
        for (int i = 0; i < tasks.length; i++) {
            min = Math.min(tasks[i][0] + tasks[i][1], min);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(earliestTime(new int[][]{{1, -1}, {100, 100}}));
    }
}
