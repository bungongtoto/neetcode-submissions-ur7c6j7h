class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0])); 

        Stack<Double> stack = new Stack<>();

        for (int index = 0 ; index < pair.length ; index++){
            double time = (double) (target -  pair[index][0]) / pair[index][1];

            System.out.println(time);

            if (stack.isEmpty()){
                 System.out.println("Run");
                stack.push(time);
            }else {
                if (stack.peek() < time){
                    System.out.println("Run");
                    stack.push(time);
                }
            }
        }

        return stack.size();
    }
}
