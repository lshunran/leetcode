package leetcode.NO450;

public class Main {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode p = root;
        TreeNode pp = null;
        while(p != null){
            if(key > p.val){
                pp = p;
                p = p.right;
            }else if(key < p.val){
                pp = p;
                p = p.left;
            }else{
                break;
            }
        }

        if(p == null) return null;

        if(p.left != null && p.right != null){
            TreeNode minp = p.right;
            TreeNode minpp = p;

            while (minp.left != null){
                minpp = minp;
                minp = minp.left;
            }

            p.val = minp.val;
            p = minp;
            pp = minpp;
        }

        TreeNode child = null;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }

        if(pp == null){
            root = child;
        }else if(pp.left == p){
            pp.left = child;
        }else{
            pp.right = child;
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
