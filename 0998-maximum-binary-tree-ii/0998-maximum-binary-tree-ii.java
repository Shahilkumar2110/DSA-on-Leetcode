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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        ArrayList<Integer> sequences=new ArrayList<>();

        traversal(root, sequences);

        sequences.add(val);
        
        return consts(sequences,0,sequences.size()-1);
        
    }

    TreeNode consts(ArrayList<Integer> sequences , int low, int high){
        if(low>high){
            return null;
        }

        int index=max_value(sequences,low,high);

        TreeNode node=new TreeNode(sequences.get(index));
        node.left=consts(sequences,low,index-1);
        node.right=consts(sequences,index+1,high);
        return node;

    }
    int max_value(ArrayList<Integer> sequences,int low, int high){
        int index=low;
        for(int i=low+1; i<=high;i++){
            if(sequences.get(index)<sequences.get(i)){
                index=i;
            }
        }
        return index;
    }

    void traversal(TreeNode root, ArrayList<Integer> sequences ){
        if(root==null) return;
        
        traversal(root.left, sequences);
        sequences.add(root.val);
        traversal(root.right, sequences);
    }
}