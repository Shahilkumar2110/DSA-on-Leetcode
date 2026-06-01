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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        return consts(root,val,depth,1);
    }
    TreeNode consts(TreeNode root , int val , int depth, int currdepth){
        if(root==null) return null;

        if(currdepth==depth-1){
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);

            leftNode.left = root.left;  
            rightNode.right = root.right; 
            
            root.left = leftNode;
            root.right = rightNode;
        }else{
            root.left=consts(root.left,val,depth,currdepth+1);
            root.right=consts(root.right,val,depth,currdepth+1);
        }
        

        return root;
    }
}