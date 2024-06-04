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

//  Normal Inorder Traversal with Space Complexity O(n)
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
        
//         List<Integer> ans=new ArrayList<>();

//         Stack<TreeNode> s=new Stack<>();

//         TreeNode node=root;

//         while(true){
//             if(node!=null){
//                 s.push(node);
//                 node=node.left;
//             }
//             else{
//                 if(s.isEmpty())
//                 break;

//                 node=s.pop();
//                 ans.add(node.val);

//                 node=node.right;
//             }
//         }

//         return ans;
//     }
// }


// Morris Traversal Technique with Space Complexity O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans=new ArrayList<>();

        TreeNode curNode = root;

        while(curNode != null) {

            // Case - 1 - When there's no left subtree of the curNode
            if(curNode.left == null) {
                ans.add(curNode.val);
                curNode = curNode.right;
            }
            else {
                TreeNode prev = curNode.left;

                while(prev.right != null && prev.right != curNode){
                    prev = prev.right;
                }

                // Case - 2 - When the rightmost child of the left subtree is pointing to null
                if(prev.right == null) {
                    prev.right = curNode; //Adding the thread
                    curNode = curNode.left;
                }

                // Case - 3 - When the rightmost child of the left subtree is pointing to the curNode
                else {
                    prev.right = null; //Removing the thread
                    ans.add(curNode.val);
                    curNode = curNode.right;
                }
            }
        }

        return ans;
    }
}