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
    int count;
    pair(TreeNode node, int count){
        this.node=node;
        this.count=count;
    }
}

class CBTInserter {

    TreeNode temp;
    Queue<pair> q;

    public CBTInserter(TreeNode root) {
        temp=root;
        q=new LinkedList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while(!bfs.isEmpty()) {
            TreeNode node=bfs.poll();

            int cnt = 0;

            if (node.left != null) {
                bfs.add(node.left);
                cnt++;
            }

            if (node.right != null) {
                bfs.add(node.right);
                cnt++;
            }
            if(cnt!=2){
                q.add(new pair(node, cnt));
            }
        }
    }
    
    public int insert(int val) {
        
        pair nodes = q.peek();
        TreeNode parent = nodes.node;

        TreeNode newNode = new TreeNode(val);

        if (nodes.count == 0) {
            parent.left = newNode;
            nodes.count = 1;
        } else {
            parent.right = newNode;
            q.poll(); 
        }

        q.add(new pair(newNode, 0));

        return parent.val;
        
    }
    
    public TreeNode get_root() {
        return temp;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */