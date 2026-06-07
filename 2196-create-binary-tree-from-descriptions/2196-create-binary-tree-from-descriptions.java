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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map=new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        TreeNode root=null;
        int n=descriptions.length;

        if(n==0) return null;

        for(int i=0;i<n;i++){

            int parent=descriptions[i][0];
            int child=descriptions[i][1];
            int isleft=descriptions[i][2];

            TreeNode node;
            TreeNode childs;
            if(map.containsKey(parent)){
                node=map.get(parent);
            }else{
                node=new TreeNode(parent);
                map.put(parent,node);
            }

            if(map.containsKey(child)){
                childs=map.get(child);
            }else{
                childs=new TreeNode(child);
                map.put(child,childs);
            }
            if(isleft==0){
                node.right=childs;
            }else{
                node.left=childs;
            }
            children.add(child);

        }

        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }
        
        return null;

    }
}