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

    int prevOrder = 0;

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        int leftAns = kthSmallest(root.left, k);

        if (leftAns != -1) {
            return leftAns;
        }

        prevOrder++;

        if (prevOrder == k) {
            return root.val;
        }

        int rightAns = kthSmallest(root.right, k);

        if (rightAns != -1) {
            return rightAns;
        }

        return -1;
    }
}