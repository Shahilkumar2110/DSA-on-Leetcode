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
    public int rob(TreeNode root) {
        HashMap<TreeNode,int[]> map=new HashMap<>();

        return funct(0,root,map);
    }
    int funct(int take, TreeNode root,HashMap<TreeNode,int[]> map){

        if(root==null) return 0;

        if (!map.containsKey(root)) {
            map.put(root, new int[] { -1, -1 });
        }
        int[] dp = map.get(root);

        if (dp[take] != -1)
            return dp[take];


        if(take==1){
            dp[1]=funct(0,root.left,map)+funct(0,root.right,map);
            return dp[1];
        }
        int nottake=funct(0,root.left,map)+funct(0,root.right,map);
        int ta=root.val+funct(1,root.left,map)+funct(1,root.right,map);

        dp[0]= Math.max(nottake,ta);
        return dp[0];
    }
}