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
    List<Integer> result=new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(!traversal(root,voyage)){
            return Arrays.asList(-1);
        }
        return result;
    }

    boolean traversal(TreeNode root, int[] voyage){
        if(root==null) return true;

        if(root.val!=voyage[index]){
            return false;
        }
        index++;
        if(root.left==null){
            return traversal(root.right,voyage);
        }else if(root.right==null){
             return traversal(root.left,voyage);
        }else{
            boolean noflip=change(root,voyage,index);

            if(noflip){
               return traversal(root.left,voyage) && traversal(root.right,voyage);
            }else{
                result.add(root.val);
                return traversal(root.right,voyage) && traversal(root.left,voyage);
            }

        }
    }

    boolean change(TreeNode root,int[] voyage, int index){
        if(index>=voyage.length) return true;
        return voyage[index]==root.left.val;
    }

}