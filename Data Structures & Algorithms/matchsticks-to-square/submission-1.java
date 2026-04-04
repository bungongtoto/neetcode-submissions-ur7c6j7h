class Solution {
    private int count = 0;
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        long sum = 0;

        for (int length : matchsticks){
            sum += length;
        }

        if ( (sum % 4) != 0)  return false;

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides);

    }


    private boolean backtrack(int[] matchsticks, int idx, int[] sides){
        if (idx == matchsticks.length ){
           return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int i = 0; i < 4; i++){
            sides[i] += matchsticks[idx];
            if (backtrack(matchsticks, idx + 1, sides)) return true;
            sides[i] -= matchsticks[idx];
        }

        return false;

    }


}