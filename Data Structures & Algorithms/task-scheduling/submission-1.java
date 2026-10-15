class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Comparator.reverseOrder());

        Map<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        maxHeap.addAll(freq.values());

        int cpuCycles = 0;
        Queue<Task> q = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            cpuCycles++;

            // Release tasks whose cooldown has expired
            while (!q.isEmpty() &&
                   q.peek().sheduledRun <= cpuCycles) {
                maxHeap.offer(q.poll().runs);
            }

            // Execute the most frequent available task
            if (!maxHeap.isEmpty()) {
                int runs = maxHeap.poll() - 1;

                if (runs > 0) {
                    Task t = new Task(runs, cpuCycles + n + 1);
                    q.offer(t);
                }
            }
        }

        return cpuCycles;

    }
}

class Task {
    int runs;
    int sheduledRun;

    public Task (int runs, int scheduled){
        this.runs = runs;
        this.sheduledRun = scheduled;
    }

    public boolean isFinish(){
        return runs == 0 ;
    }

}
