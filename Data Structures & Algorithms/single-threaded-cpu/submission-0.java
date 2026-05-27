class Solution {
    private record Task(int index, int enqueueTime, int processTime) {
    }
    List<Task> taskList = new ArrayList<>();

    public int[] getOrder(int[][] tasks) {

        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        // Sort based on enqueue time, and if equal then by process time
        taskList.sort((t1, t2) -> t1.enqueueTime == t2.enqueueTime ? t1.processTime - t2.processTime : t1.enqueueTime - t2.enqueueTime);

        // Priority queue: shortest process time first, then by index
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>((t1, t2) ->
                t1.processTime == t2.processTime ? t1.index - t2.index : t1.processTime - t2.processTime);

        int[] resultArray = new int[tasks.length];
        int resultIdx = 0, processIdx = 0, currentTime = 0;

        while (processIdx < tasks.length || !priorityQueue.isEmpty()) {
            // Add all tasks that have arrived by current time
            while (processIdx < tasks.length && taskList.get(processIdx).enqueueTime <= currentTime) {
                priorityQueue.add(taskList.get(processIdx));
                processIdx++;
            }

            if (!priorityQueue.isEmpty()) {
                // Process the task with highest priority
                Task currentTask = priorityQueue.poll();
                currentTime = Math.max(currentTask.enqueueTime, currentTime) + currentTask.processTime;
                resultArray[resultIdx++] = currentTask.index;
            } else {
                // No tasks available, jump to next task's enqueue time
                if (processIdx < tasks.length) {
                    currentTime = taskList.get(processIdx).enqueueTime;
                }
            }
        }

        return resultArray;
    }
}