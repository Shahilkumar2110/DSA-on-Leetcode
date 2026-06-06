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
    int col;
    int row;
    pair(TreeNode node,int row, int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();

        if(root==null) return result;

        List<pair> data=new ArrayList<>();

        inserted(root,0,0,data);

        Collections.sort(data,(a,b)->{
            if(a.col!=b.col) return a.col-b.col;
            if(a.row!=b.row) return a.row-b.row;
            return a.node.val-b.node.val;
        });

        int pre=Integer.MIN_VALUE;

        for(pair nodes:data){
            if(pre!=nodes.col){
                result.add(new ArrayList<>());
                pre=nodes.col;
            }
            result.get(result.size()-1).add(nodes.node.val);
        }
        return result;

    }
    void inserted(TreeNode root, int row, int col, List<pair> data){
        if(root==null) return;

        data.add(new pair(root, row,col));

        inserted(root.left,row+1,col-1,data);
        inserted(root.right,row+1,col+1,data);

    }
}