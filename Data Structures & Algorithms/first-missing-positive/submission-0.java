class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for(int num: nums){
            numsSet.add(num);
        }

        int smallPositive  = 1;

        while (true){
            if (!numsSet.contains(smallPositive)){
                return smallPositive;
            }
            smallPositive++;
        }
        
    }
}