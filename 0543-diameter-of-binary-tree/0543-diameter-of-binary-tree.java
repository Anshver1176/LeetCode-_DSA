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

    public int diameterOfBinaryTree(TreeNode root) {
        return Diameter(root);
    }

    public int Diameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ld = Diameter(root.left);
        int rd = Diameter(root.right);

        int lh = Height(root.left);
        int rh = Height(root.right);

        int selfDiameter = lh + rh;

        return Math.max(selfDiameter, Math.max(ld, rd));
    }

    public int Height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = Height(root.left);
        int rh = Height(root.right);

        return Math.max(lh, rh) + 1;
    }
}