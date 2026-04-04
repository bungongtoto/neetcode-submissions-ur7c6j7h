class Solution {
    /**
     * @param {number} target
     * @param {number[]} position
     * @param {number[]} speed
     * @return {number}
     */
    carFleet(target, position, speed) {
        /**
         * 
         */
        //stores the count of cars that take thesame time to get to target
        const pair  = position.map((p, i) => [p, speed[i]]);
        pair.sort((a, b) => b[0] - a[0]);
        console.log(pair);

        let stack = [];

        for (const [p, s] of pair){
            stack.push((target - p)/s);
            console.log(stack);

            if (stack.length >= 2 && stack[stack.length -1] <= stack[stack.length -2]){
                stack.pop();
            }
        }

        return stack.length;
    }
}
