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
    boolean result=true;
    public boolean isCompleteTree(TreeNode root) {
        traversal(root);
        return result;
    }
    void traversal(TreeNode root){
        if(root==null) return;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        boolean yes=false;

        while(!q.isEmpty()){
            TreeNode node=q.poll();

            if(node==null){
                yes=true;
            }

            if(node!=null){

                if(yes){
                    result=false;
                    return;
                }

                q.add(node.left);
                q.add(node.right);

            }
        }
    }
}