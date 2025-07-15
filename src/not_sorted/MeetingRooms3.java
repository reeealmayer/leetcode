package not_sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) availableRooms.offer(i);

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Integer.compare((int) a[1], (int) b[1])
        );

        int[] usageCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // Освободить комнаты, у которых закончилось время до начала текущей встречи
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                busyRooms.offer(new long[]{start + duration, room});
                usageCount[room]++;
            } else {
                long[] soonest = busyRooms.poll();
                long newStart = soonest[0];
                int room = (int) soonest[1];
                busyRooms.offer(new long[]{newStart + duration, room});
                usageCount[room]++;
            }
        }

        // Найти комнату с макс количеством использований
        int maxUsed = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (usageCount[i] > maxUsed) {
                maxUsed = usageCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;

    }
}
