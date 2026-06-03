/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    HashSet<TreeNode> visited=new HashSet<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mapped(root,null);
        range(target, k);
        return result;
    }
    void mapped(TreeNode root, TreeNode parent){
        if(root==null) return;

        map.put(root,parent);
        mapped(root.left,root);
        mapped(root.right,root);
    }
    void range(TreeNode root, int k){
        if(root==null || visited.contains(root)) return;

        visited.add(root);
        if(k==0){
            result.add(root.val);
            return;
        }
        range(root.left,k-1);
        range(root.right,k-1);
        range(map.get(root),k-1);
        


    }
}