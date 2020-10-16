package shuo.laoma.collection.c46;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyTaskQueue {
    static class Task {
        // 优先级，值越大优先级越高
        int priority;
        // 任务名称
        String name;

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        public int getPriority() {
            return priority;
        }

        public String getName() {
            return name;
        }
    }

    static class TaskComparator implements Comparator<Task> {

        @Override
        public int compare(Task o1, Task o2) {
            if (o1.getPriority() > o2.getPriority()) {
                return -1;
            } else if (o1.getPriority() == o2.getPriority()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Queue<MyTaskQueue.Task> tasks = new PriorityQueue<>(new TaskComparator());
        tasks.offer(new MyTaskQueue.Task(20, "写日记"));
        tasks.offer(new MyTaskQueue.Task(10, "看电视"));
        tasks.offer(new MyTaskQueue.Task(100, "写代码"));
        MyTaskQueue.Task task = tasks.poll();
        while (task != null) {
            System.out.print("处理任务: " + task.getName()
                    + "，优先级:" + task.getPriority() + "\n");
            task = tasks.poll();
        }
    }
}
