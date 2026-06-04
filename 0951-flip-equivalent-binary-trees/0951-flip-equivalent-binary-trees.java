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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        traversal(root1,root2);
        return result;
    }
    void traversal(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return;
        if(root1==null || root2==null){
            result=false;
            return;
        }

        if(root1.val!=root2.val){
            result=false;
            return;
        }

        if(!result) return;

        boolean flip=issame(root1.left,root2.right)&& issame(root1.right,root2.left);

        boolean noflip=issame(root1.left,root2.left)&& issame(root1.right,root2.right);

        if(flip){
            traversal(root1.left, root2.right);
            traversal(root1.right,root2.left);
        }else if(noflip){
            traversal(root1.left, root2.left);
            traversal(root1.right,root2.right);
        }else{
            result=false;
            return;
        }


    }
    boolean issame(TreeNode a, TreeNode b){
        if(a==null && b==null ) return true;
        if(a==null || b==null ) return false;
        return a.val==b.val;
    }
}