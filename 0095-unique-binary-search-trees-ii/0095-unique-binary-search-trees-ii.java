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
    public List<TreeNode> generateTrees(int n) {
        return funct(1,n);
    }
    List<TreeNode> funct(int low, int high){
        List<TreeNode> result=new ArrayList<>();

        if(low>high){
            result.add(null);
            return result;
        }

        for(int i=low;i<=high;i++){

            List<TreeNode> left=funct(low,i-1);
            List<TreeNode> right=funct(i+1,high);


            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode node=new TreeNode(i);
                    node.left=l;
                    node.right=r;
                    result.add(node);
                }
            }


        }
        return result;
    }
}