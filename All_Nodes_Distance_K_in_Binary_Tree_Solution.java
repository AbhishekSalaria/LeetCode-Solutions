public class All_Nodes_Distance_K_in_Binary_Tree_Solution {
    Map<Integer,TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int dist = 0;
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while(!queue.isEmpty() && dist != k) {
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode removed = queue.remove();
                if(removed.left != null && !visited.contains(removed.left)) {
                    queue.add(removed.left);
                    visited.add(removed.left);
                }
                if(removed.right != null && !visited.contains(removed.right)) {
                    queue.add(removed.right);
                    visited.add(removed.right);
                }
                if(parents.containsKey(removed.val) && !visited.contains(parents.get(removed.val))) {
                    queue.add(parents.get(removed.val));
                    visited.add(parents.get(removed.val));
                }
            }
            dist++;
        }
        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            answer.add(queue.remove().val);
        }
        return answer;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if(parent != null) {
            parents.put(node.val,parent);
        }
        if(node.left != null) {
            dfs(node.left,node);
        }
        if(node.right != null) {
            dfs(node.right,node);
        }

    }
}