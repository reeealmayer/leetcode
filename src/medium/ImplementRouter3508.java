package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ImplementRouter3508 {

    private int avalableMemory;
    private final Queue<Packet> packetQueue;
    private final Set<Packet> packetSet;
    private final Map<Integer, List<Packet>> destinationToPacketsMap;
    private final Map<Integer, Integer> destinationToStartIndexMap;


    static class Packet {
        int source;
        int destination;
        int timestamp;


        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;

            Packet packet = (Packet) object;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            int result = source;
            result = 31 * result + destination;
            result = 31 * result + timestamp;
            return result;
        }

    }

    public ImplementRouter3508(int memoryLimit) {
        this.avalableMemory = memoryLimit;
        this.packetQueue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destinationToPacketsMap = new HashMap<>();
        this.destinationToStartIndexMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet newPacket = new Packet(source, destination, timestamp);
        if (packetSet.contains(newPacket)) {
            return false;
        }

        if (avalableMemory > 0) {
            avalableMemory--;
        } else {
            Packet oldestPacket = packetQueue.remove();
            packetSet.remove(oldestPacket);

            int destinationId = oldestPacket.destination;
            int currentStartIndex = destinationToStartIndexMap.get(destinationId);
            destinationToStartIndexMap.put(destinationId, currentStartIndex + 1);
        }

        packetQueue.add(newPacket);
        packetSet.add(newPacket);

        destinationToPacketsMap.putIfAbsent(destination, new ArrayList<>());
        destinationToStartIndexMap.putIfAbsent(destination, 0);

        destinationToPacketsMap.get(destination).add(newPacket);

        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) {
            return new int[]{};
        }

        Packet packetToForward = packetQueue.remove();
        packetSet.remove(packetToForward);

        int destinationId = packetToForward.destination;
        List<Packet> packetsForDestination = destinationToPacketsMap.get(destinationId);

        int newStartIndex = destinationToStartIndexMap.get(destinationId) + 1;
        destinationToStartIndexMap.put(destinationId, newStartIndex);

        if (newStartIndex >= packetsForDestination.size()) {
            destinationToPacketsMap.remove(destinationId);
            destinationToStartIndexMap.remove(destinationId);
        }

        avalableMemory++;

        return new int[] {packetToForward.source, packetToForward.destination, packetToForward.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Packet> packetsForDestination = destinationToPacketsMap.get(destination);
        if (packetsForDestination == null || packetsForDestination.isEmpty()) {
            return 0;
        }

        Integer startIndex = destinationToStartIndexMap.getOrDefault(destination, 0);
        int lowerBoundIndex = findLowerBoundIndex(packetsForDestination, startTime, startIndex);
        int upperBoundIndex = findUpperBoundIndex(packetsForDestination, endTime, startIndex);

        return upperBoundIndex - lowerBoundIndex;
    }

    private int findLowerBoundIndex(List<Packet> packets, int time, int starIndex) {
        int left = starIndex;
        int right = packets.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (packets.get(mid).timestamp >= time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findUpperBoundIndex(List<Packet> packets, int time, int starIndex) {
        int left = starIndex;
        int right = packets.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (packets.get(mid).timestamp > time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ImplementRouter3508 router = new ImplementRouter3508(4);
        System.out.println(router.addPacket(1, 2, 1));
        System.out.println(router.addPacket(2, 2, 2));
        System.out.println(router.addPacket(3, 2, 3));
        System.out.println(router.addPacket(4, 2, 4));

//        System.out.println(Arrays.toString(router.forwardPacket()));
//        System.out.println(Arrays.toString(router.forwardPacket()));
//        System.out.println(Arrays.toString(router.forwardPacket()));
//        System.out.println(Arrays.toString(router.forwardPacket()));

        System.out.println(router.getCount(2, 1, 4));
    }
}
