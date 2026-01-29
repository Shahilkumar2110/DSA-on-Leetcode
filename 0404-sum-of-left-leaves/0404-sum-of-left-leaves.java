class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null) {
                    sum += curr.left.val;
                } else {
                    q.add(curr.left);
                }
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return sum;
    }
}
