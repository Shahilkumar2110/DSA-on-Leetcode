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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        return funct(preorder,0,preorder.length-1,map);


    }
    public TreeNode funct(int[] preorder, int left,int right,Map<Integer,Integer> map){
        
        if(right<left) return null;
        TreeNode node=new TreeNode(preorder[index]);

        int inorderindex=map.get(preorder[index++]);

        node.left=funct(preorder, left,inorderindex-1,map);
        node.right=funct(preorder,inorderindex+1,right,map);
        return node;
    }
}