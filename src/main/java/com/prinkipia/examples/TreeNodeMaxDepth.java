package com.prinkipia.examples;

/**
 * Created by Tom on 5/28/2016.
 */
public class TreeNodeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
