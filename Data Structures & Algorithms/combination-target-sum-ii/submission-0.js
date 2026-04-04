class Solution {
    /**
     * @param {number[]} candidates
     * @param {number} target
     * @return {number[][]}
     */
    combinationSum2(candidates, target) {
        candidates.sort((a, b) => a - b);
        const res  = [];
        this.dfs(candidates, target, 0, [], 0, res);
        return res;
    }

    dfs (candidates, target, i , cur, total, res){
        if (target === total){
            res.push([...cur]);
            return;
        }

        if (total > target || i === candidates.length) return;

        cur.push(candidates[i]);
        this.dfs(candidates, target, i+1, cur, total + candidates[i], res);
        cur.pop();

        while (i+1 < candidates.length && candidates[i] === candidates[i+1]){
            i++;
        }

        this.dfs(candidates , target, i+1, cur, total, res);
    }
}
