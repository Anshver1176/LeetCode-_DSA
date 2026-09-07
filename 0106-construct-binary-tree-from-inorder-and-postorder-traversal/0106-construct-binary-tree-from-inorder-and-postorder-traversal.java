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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {

        // No elements
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of postorder is the root
        int rootValue = postorder[postEnd];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int index = inStart;

        while (inorder[index] != rootValue) {
            index++;
        }

        // Number of nodes in left subtree
        int leftSize = index - inStart;

        // Build left subtree
        root.left = build(
            inorder, inStart, index - 1,
            postorder, postStart, postStart + leftSize - 1
        );

        // Build right subtree
        root.right = build(
            inorder, index + 1, inEnd,
            postorder, postStart + leftSize, postEnd - 1
        );

        return root;
    }
}