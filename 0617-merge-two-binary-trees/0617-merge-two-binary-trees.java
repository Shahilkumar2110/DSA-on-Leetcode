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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1==null) return root2;
        if(root2==null) return root1;

        TreeNode merge = new TreeNode(root1.val+root2.val);
        merge.left=mergeTrees(root1.left, root2.left);
        merge.right=mergeTrees(root1.right, root2.right);
        return merge;



        // TreeNode result=merge(root1,root2);
        // return result;
    }
    // TreeNode merge(TreeNode root1, TreeNode root2){
    //     if(root1==null && root2==null){
    //         return null;
    //     }
    //     int val1=root1==null?0:root1.val;
    //     int val2=root2==null?0:root2.val;

    //     TreeNode result=new TreeNode(val1+val2);

    //     if(root1==null && root2!=null){
            
    //     result.left=merge(root1, root2.left);
    //     result.right=merge(root1, root2.right);

    //     }else if(root2==null && root1!=null){
            
    //     result.left=merge(root1.left, root2);
    //     result.right=merge(root1.right, root2);

    //     }else{
        
    //     result.left=merge(root1.left, root2.left);
    //     result.right=merge(root1.right, root2.right);

    //     }


    //     return result;
    // }
}