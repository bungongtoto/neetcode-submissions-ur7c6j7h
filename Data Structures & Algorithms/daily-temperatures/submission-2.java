class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while(i < n){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }

            stack.push(i);
            i++;
        }

        return res;
    }
}
