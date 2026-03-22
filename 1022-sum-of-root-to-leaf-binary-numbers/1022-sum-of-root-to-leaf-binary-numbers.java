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
    public int sumRootToLeaf(TreeNode root) {
        StringBuffer str=new StringBuffer();
        funct(root,str);

        int sum=0;
        for(int i=0;i<make.size();i++){
            sum+=Integer.parseInt(make.get(i),2);
        }
        return sum;

    }
    ArrayList<String> make=new ArrayList<>();

    void funct(TreeNode root,StringBuffer str){
        if(root==null) return;

        str.append(root.val);
        
        funct(root.left,str);
        
        funct(root.right,str);
        if(root.left==null && root.right==null){
            make.add(str.toString());
        }

        str.deleteCharAt(str.length() - 1);
    }
}