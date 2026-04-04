class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;

        while (index1 < index2){
            int sum = numbers[index1] + numbers[index2];

            if (target > sum){
                index1++;
            }else if (target < sum){
                index2--;
            }else {
                return new int[]{index1 + 1, index2 + 1};
            }
        }

        return new int[]{index1 + 1,index2 + 1};
    }
}
