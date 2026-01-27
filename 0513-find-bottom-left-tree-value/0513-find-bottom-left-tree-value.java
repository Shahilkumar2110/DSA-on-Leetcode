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
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> arr=new LinkedList<>();

        int ans=root.val;
        arr.add(root);
        while(!arr.isEmpty()){

            int n=arr.size();
            for(int i=0;i<n;i++){
                TreeNode nothing=arr.poll();

                if(i==0){
                    ans=nothing.val;
                }
                
                if(nothing.left!=null) arr.add(nothing.left);
                if(nothing.right!=null) arr.add(nothing.right);
            }

        }

        return ans;

    }
}