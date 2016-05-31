package com.prinkipia.examples;

public class CreateMinimalBST {
    static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(final int[] array, final int start, final int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7};

        TreeNode node = createMinimalBST(array);
        System.out.println(node);
    }


}
