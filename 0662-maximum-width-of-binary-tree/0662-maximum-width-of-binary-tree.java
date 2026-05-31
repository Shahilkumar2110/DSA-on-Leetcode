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
 class pair{
    TreeNode node;
    int pos;
    pair(TreeNode node, int pos){
        this.node=node;
        this.pos=pos;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));

        int dist=0;

        while(!q.isEmpty()){
            int si=q.size();
            int start=q.peek().pos;
            int end=start;
            for(int i=0;i<si;i++){

                pair nod=q.poll();

                TreeNode nodes=nod.node;
                int position=nod.pos;

                end=position;

                if (nodes.left != null)
                    q.add(new pair(nodes.left, 2 * position));

                if (nodes.right != null)
                    q.add(new pair(nodes.right, 2 * position + 1));
            }
            dist=Math.max(dist,end-start+1);
        }
        return dist;

    }
}