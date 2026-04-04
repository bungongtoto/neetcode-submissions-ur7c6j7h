/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private List<List<Integer>> res = new ArrayList<>(); 

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ) return res;
        bfs(root);

        return res;
    }

    private void bfs(TreeNode root){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for (int index = 0 ; index < n; index++){
                TreeNode node =  queue.poll();
                
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            res.add(new  ArrayList(level));
        }
    }
}
