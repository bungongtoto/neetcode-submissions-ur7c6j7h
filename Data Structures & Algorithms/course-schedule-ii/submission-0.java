class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();

    List<Integer> res = new ArrayList<>();

    Set<Integer> visited = new HashSet<>();
    Set<Integer> completed = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0 ; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for (int c = 0 ; c < numCourses; c++){
            if (!dfs(c)) return new int[]{};
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int c ){
        if (completed.contains(c)) {
            return true;
        }

        if (visited.contains(c)){
            return false;
        }

        visited.add(c);

        for (int pre : preMap.get(c)){
            if (!dfs(pre)){
                return false;
            }
            
        }

        visited.remove(c);
        completed.add(c);
        res.add(c);

        return true;
    }
}
