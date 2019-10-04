package medium;

public class BSTToGreaterSumTreeDemo {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //======solution_1=======
    public TreeNode solution_1(TreeNode root){
        //实际就是一个倒着的逆序遍历
        if(root == null)
            return null;
        else{
            inorder(root, 0);
            return root;
        }
    }

    public int inorder(TreeNode node, int val){
        int rightSum;
        int leftSum;
        if(node == null){
            return val;
        }else{
            rightSum = inorder(node.right, val);
            node.val = rightSum + node.val ;//如果是先向左,再向右,那么遇到空结点时,返回的rightSum就是之前带进去的信息
            leftSum = inorder(node.left, node.val);
            return leftSum;
        }
    }
}

//两个错点:首先,第一步向右遍历的时候不能直接传0,这样的话,先向左再向右的时候就失去了前面的值
         //其次,在当前点返回的应该是左边结点的值
         //其次,在遇到空的时候要返回传入的数值.有两种情况:如果一直向右遍历,那么就返回了0,如果向左遍历一次,就要带上遍历开始的结点的值,再遇到空的时候会返回之前的信息

