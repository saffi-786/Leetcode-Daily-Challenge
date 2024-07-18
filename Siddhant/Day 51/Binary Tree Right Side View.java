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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        task(root,0,ans);
        return ans;
    }
    private void task(TreeNode root, int level, List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        if(level==ans.size())
        {
            ans.add(root.val);
        }
        task(root.right,level+1,ans);
        task(root.left,level+1,ans);
    }
}