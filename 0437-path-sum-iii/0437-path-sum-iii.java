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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }

        int take=funct(0,root,targetSum);

        int notleft=pathSum(root.left,targetSum)+pathSum(root.right,targetSum);

        return take+notleft;

    }

    int funct(long sum, TreeNode root, int target){
        if(root==null ){
            return 0;
        }

        long newsum=sum+root.val;

        int take=0;

        if(newsum==target){
            take++;
        }

        take+=funct(newsum,root.left,target);
        take+=funct(newsum,root.right,target);

        return take;
    }


}