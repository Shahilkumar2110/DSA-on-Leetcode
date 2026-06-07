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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=preorder.clone();

        Arrays.sort(inorder);

        return consts(inorder,0,inorder.length-1,preorder,0);

    }
    TreeNode consts(int[] inord, int inlow, int inhigh, int[] preord, int index){
        if(inlow>inhigh) return null;

        int index2=search(inord,inlow,inhigh, preord[index]);

        TreeNode node=new TreeNode(inord[index2]);

        node.left=consts(inord,inlow,index2-1,preord,index+1);
        node.right=consts(inord,index2+1,inhigh,preord, index2-inlow+1+index );

        return node;
    }
    int search(int[] inord, int low, int high, int val){
        for(int i=low;i<=high;i++){
            if(inord[i]==val) return i;
        }
        return -1;
    }
}