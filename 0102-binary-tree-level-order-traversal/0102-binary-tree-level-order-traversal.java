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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr=new ArrayList<>();

        Queue<TreeNode> node=new LinkedList<>();
        if(root==null) return arr;
        node.add(root);

        while(!node.isEmpty()){
            List<Integer> part=new ArrayList<>();

            int n=node.size();
            for(int i=0;i<n;i++){
                TreeNode element=node.poll();
                part.add(element.val);

                if(element.left!=null){
                    node.add(element.left);
                }
                if(element.right!=null){
                    node.add(element.right);
                }
            }
            arr.add(part);
        }
        return arr;

    }
}