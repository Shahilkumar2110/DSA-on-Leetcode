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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return consts(nums,0,nums.length-1);
    }
    TreeNode consts(int[] nums, int start, int end){
        if(start>end) return null;

        int index=start;
        int max=nums[index];
        for(int i=start;i<=end;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }

        TreeNode node=new TreeNode(nums[index]);
        node.left=consts(nums,start,index-1);
        node.right=consts(nums,index+1,end);
        return node;

    }
}