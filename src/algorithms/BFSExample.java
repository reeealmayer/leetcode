package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFSExample {
    static List<Integer> bfsShortestPath(Map<Integer, List<Integer>> graph, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == target) {
                return reconstructPath(parent, target);
            }

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(node, neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private static List<Integer> reconstructPath(Map<Integer, Integer> parent, int target) {
        List<Integer> path = new ArrayList<>();
        Integer cur = target;
        while (cur != null) {
            path.add(cur);
            cur = parent.get(cur);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // Пример графа
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0, 3, 4));
        graph.put(3, Arrays.asList(1, 2, 4));
        graph.put(4, Arrays.asList(2, 3));

        int start = 0;
        int target = 4;

        List<Integer> path = bfsShortestPath(graph, start, target);
        System.out.println("Кратчайший путь: " + path);
    }
}
