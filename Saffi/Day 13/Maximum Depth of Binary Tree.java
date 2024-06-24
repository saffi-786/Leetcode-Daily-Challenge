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
    static int ans;
    public int maxDepth(TreeNode root) {
        ans = 0;

        task(root);

        return ans;
    }

    static int task(TreeNode root) {
        if(root == null) return 0;

        int leftTree = task(root.left);
        int rightTree = task(root.right);

        ans = Math.max(ans, 1 + Math.max(leftTree, rightTree));

        return 1 + Math.max(leftTree, rightTree);
    }
}