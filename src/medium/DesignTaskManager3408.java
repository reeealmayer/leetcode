package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignTaskManager3408 {
    static class Task {
        int userId;
        int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Map<Integer, Task> taskMap = new HashMap<>();

    private PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
       if (a.priority != b.priority) {
           return b.priority - a.priority;
       }  else {
           return b.taskId - a.taskId;
       }
    });

    public DesignTaskManager3408(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old != null) {
            Task updated = new Task(old.userId, taskId, newPriority);
            taskMap.put(taskId, updated);
            pq.offer(updated);
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task current = taskMap.get(top.taskId);
            if (current != null && current.priority == top.priority) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }

        return -1;
    }
}
