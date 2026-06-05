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
    String result="";
    public String smallestFromLeaf(TreeNode root) {
        if(root==null) return new String("");

        StringBuilder str=new StringBuilder();
        traversal(root,str);
        return result;
    }

    void traversal(TreeNode root,StringBuilder str){
        if(root==null){
            return;
        }

        str.append((char)(root.val+'a'));
        
        if (root.left == null && root.right == null) {
            String curr = new StringBuilder(str).reverse().toString();

            if (result.equals("") || curr.compareTo(result) < 0) {
                result = curr;
            }
        }

        traversal(root.left, str);
        traversal(root.right, str);

        str.deleteCharAt(str.length() - 1);
    }
}