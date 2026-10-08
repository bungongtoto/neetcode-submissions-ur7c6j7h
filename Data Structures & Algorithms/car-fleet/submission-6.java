class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();

        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++){
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        for (int[] pair : pairs){
            double time = (double) (target - pair[0]) / pair[1];

            if (stack.isEmpty()){
                stack.push(time);
            }else{
                if (time > stack.peek()){
                    stack.push(time);
                }
            }
        }

        return stack.size();
        
    }
}
