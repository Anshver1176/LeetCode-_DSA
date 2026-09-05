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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i = 0;

        // Find the first different node
        while (i < path1.size() && i < path2.size()) {

            if (path1.get(i) != path2.get(i)) {
                break;
            }

            i++;
        }

        // Previous node was the LCA
        return path1.get(i - 1);
    }

    static boolean getPath(TreeNode root, TreeNode target,
                           ArrayList<TreeNode> path) {

        if (root == null) {
            return false;
        }

        // Add current node to path
        path.add(root);

        // Target found
        if (root == target) {
            return true;
        }

        // Search left subtree
        boolean foundLeft = getPath(root.left, target, path);

        // Search right subtree
        boolean foundRight = getPath(root.right, target, path);

        if (foundLeft || foundRight) {
            return true;
        }

        // Target not found in this subtree
        path.remove(path.size() - 1);

        return false;
    }
}