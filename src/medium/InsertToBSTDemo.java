package medium;

public class InsertToBSTDemo {


    //===========solution_1============
    //这个答案一遍过,嘻嘻  递归的时候,选择处理当前点还是处理子节点需要考虑
    public TreeNode solution_1(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }else{//当前结点非空,如果大,则判断右边结点,如果小,则判断左边结点
            if(root.val > val){
                if(root.left == null){
                    root.left = new TreeNode(val);
                }else {
                    solution_1(root.left, val);
                }
            }else{
                if(root.right == null){
                    root.right = new TreeNode(val);
                }else {
                    solution_1(root.right, val);
                }
            }
        }

        return root;
    }



    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
