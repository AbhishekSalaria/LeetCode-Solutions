public class Minimum_Depth_of_Binary_Tree_Solution {
    public int minDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while(!queue.isEmpty()) {
            int queueLen = queue.size();
            count += 1;
            for(int i = 0; i < queueLen;i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left == null && node.right == null) {
                    return count;
                }
            }
        }
        return 0;
    }
}