package easy;


import java.util.Stack;

public class MergeBST {

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    //===================solution_1====================
    //自己写的辣鸡算法，思路不清晰
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        //#1
        if(t1 != null && t2 != null)
            t1.val += t2.val;
        else if(t2 == null)
            return t1;
        else//这种情况下，t1可空
            return t2;

        //#2
        if(t1.left != null && t2.left != null){
            mergeTrees(t1.left, t2.left);
        }else if(t1.left == null && t2.left != null){
            t1.left = t2.left;
        }

        if(t1.right != null && t2.right != null){
            mergeTrees(t1.right, t2.right);
        }else if(t1.right == null && t2.right != null){
            t1.right = t2.right;
        }
        return t1;
    }

    //===================solution_2====================
    public TreeNode mergeTrees_2(TreeNode t1, TreeNode t2){
        //solution中#1的简化版
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode node = new TreeNode(0);
        node.val = t1.val + t2.val;

        node.left = mergeTrees_2(t1.left, t2.left);
        node.right = mergeTrees_2(t1.right, t2.right);

        return node;
    }

    //===================solution_3====================
    public TreeNode mergeTrees_3(TreeNode t1, TreeNode t2){
        if (t1 == null)
            return t2;
        Stack< TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }

}
