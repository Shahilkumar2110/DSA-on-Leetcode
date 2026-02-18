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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> part=new ArrayList<>();

            for(int i=0;i<n;i++){

                TreeNode element=q.poll();
                part.add(element.val);
                if(element.left!=null) q.add(element.left);
                if(element.right!=null) q.add(element.right);

            }
            result.add(part);

        }

        Collections.reverse(result);
        return result;


    }
}