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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            double sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();

                sum += currNode.val;

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }

                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            double average = sum / levelSize;
            res.add(average);
        }

        return res;
    }
}