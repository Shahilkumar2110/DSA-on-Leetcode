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
    public List<List<String>> printTree(TreeNode root) {
        int height=findheight(root);
        int cols=(1 << height) - 1;

        List<List<String>> result=new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            result.add(row);
        }

        fill(result, root, 0, 0, cols - 1);
        return result;

    }

    void fill(List<List<String>> res, TreeNode root, int row, int left, int right) {
        if (root == null) return;

        int mid = (left + right) / 2;
        res.get(row).set(mid, String.valueOf(root.val));

        fill(res, root.left, row + 1, left, mid - 1);
        fill(res, root.right, row + 1, mid + 1, right);
    }

    int findheight(TreeNode root){
        if(root==null) return 0;
        int left=findheight(root.left);
        int right=findheight(root.right);
        return Math.max(left,right)+1;
    }
}