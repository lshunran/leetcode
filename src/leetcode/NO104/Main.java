package leetcode.NO104;

import com.sun.source.tree.BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class Main {
    private ArrayList arr = new ArrayList();

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
