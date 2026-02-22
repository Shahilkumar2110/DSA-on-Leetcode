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
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> part=new ArrayList<>();
        funct(root,targetSum, part);
        return result;
    }
     void funct(TreeNode root,int targetleft,List<Integer> part){
        if(root==null) return ;
        part.add(root.val);

        if (root.left == null && root.right == null && root.val == targetleft) {
            result.add(new ArrayList<>(part)); 
        } else {
            funct(root.left, targetleft - root.val, part);
            funct(root.right, targetleft - root.val, part);
        }

        part.remove(part.size() - 1);

    }
}