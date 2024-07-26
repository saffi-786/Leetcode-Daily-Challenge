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
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inOrderTraversal(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

     
        inOrderTraversal(node.left);

 
        if (first == null && node.val < prev.val) {
            first = prev;
        }
        if (first != null && node.val < prev.val) {
            second = node;
        }

      
        prev = node;

      
        inOrderTraversal(node.right);
    }
}