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
    int index;
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        index=inorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        if(inorder.length==0){
            return null;
        }

        return funct(postorder,0,postorder.length-1);


    }
    public TreeNode funct(int[] postorder,int left,int right){

        if(left>right) return null;

        int val=postorder[index--];

        TreeNode node=new TreeNode(val);
        int index2=map.get(val);

        node.right=funct(postorder,index2+1,right);

        node.left=funct(postorder,left,index2-1);
        return node;


    }   
}