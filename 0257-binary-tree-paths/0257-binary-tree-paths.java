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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        funct(root,"",result);
        return result;
    }

    void funct(TreeNode root,String str,List<String> result){
        if(root==null) return;

        if(str==""){
            str=""+root.val;
        }else{
            str=str+"->"+root.val;
        }

        if(root.left==null && root.right==null){
            result.add(str);
            return;
        }
        funct(root.left,str,result);
        funct(root.right,str,result);
    }

}