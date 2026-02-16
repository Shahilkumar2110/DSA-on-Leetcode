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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ltr=0;

        while(!q.isEmpty()){
            int n=q.size();
            int index=0;
            int[] part=new int[n];
            for(int i=0;i<n;i++){
                TreeNode element=q.poll();
                part[index++]=element.val;
                if(element.left!=null) q.add(element.left);
                if(element.right!=null) q.add(element.right);
                
            }
            List<Integer> part2=new ArrayList<>();
            if(ltr%2==0){
                for(int e:part){
                    part2.add(e);
                }
            }else{
                for(int i=n-1;i>=0;i--){
                    part2.add(part[i]);
                }
            }
            result.add(part2);
            ltr++;
        }
        return result;


    }
}