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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});


        while (!queue.isEmpty()){
            Object[] current = queue.poll();

            TreeNode node = (TreeNode) current[0];

            int left = (int) current[1];
            int right = (int) current[2];

            if (!(left < node.val && right > node.val))  return false;

            if (node.left != null){
                queue.offer(new Object[]{node.left, left, node.val});
            }

            if (node.right != null){
                queue.offer(new Object[] {node.right, node.val, right});
            }
        }

        return true;
    }
}
