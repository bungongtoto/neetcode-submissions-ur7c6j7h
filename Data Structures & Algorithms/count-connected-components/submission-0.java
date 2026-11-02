class Solution {

    private Set<Integer> visited = new HashSet<>();
    private List<List<Integer>> adj;

    public int countComponents(int n, int[][] edges) {

        adj = new ArrayList<>();

        for (int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for (int i = 0 ; i < n; i++){
            if (!visited.contains(i)){
                dfs(i);
                count++;
            }
        }

        return count;
    }


    private void dfs(int c){
        if (visited.contains(c)) return;

        visited.add(c);

        for (int nei : adj.get(c)){
            dfs(nei);
        }

        return;
    }
}
