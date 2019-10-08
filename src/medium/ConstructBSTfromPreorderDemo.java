package medium;

import sun.reflect.generics.tree.Tree;

public class ConstructBSTfromPreorderDemo {
    public static void main(String[] args) {
        new ConstructBSTfromPreorderDemo().bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

    //basic question
    //递归构建
    int nextIndex = 0;
    TreeNode root;
    public TreeNode bstFromPreorder(int[] preorder){

        int divide = 1;
        if(preorder == null) return null;
        else{
            //当前结点的左结点是当前起始坐标到小于当前结点值的一部分,
            //当前结点的右结点是第一个大于当前结点的
            return constructor(preorder, 0, preorder.length - 1);
//            TreeNode root = new TreeNode(preorder[0]);
//            for(int i = 1; i < preorder.length; i++){
//                if(preorder[i] < root.val){
//                    divide = i;
//                }else{
//                    break;
//                }
//            }
//            root.left = constructor(preorder, 1, divide);
//            root.left = constructor(preorder, divide + 1, preorder.length - 1);
//            return root;
        }
    }

    public TreeNode constructor(int[] preorder, int start, int end){
        int divide = start;
        TreeNode node = new TreeNode(preorder[start]);
        //找到左右子树的分界点
        for(int i = start + 1; i <= end; i++){
            if(preorder[i] < node.val){
                divide = i;
            }else{
                break;
            }
        }//如果右边有界,存在有节点,如果左边有界,存在左结点
        if(++start <= divide){
            node.left = constructor(preorder, start, divide);
        }
        if(++divide <= end){
            node.right = constructor(preorder, divide, end);
        }
        return node;
    }

    //========solution_2===========
    //直接构建
    public TreeNode bstFromPreorder_2(int[] preorder){
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node = root;
        for(int i = 1; i < preorder.length; i++) {
            while (true) {
                if (preorder[i] < node.val) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new TreeNode(preorder[i]);
                        node = root;
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new TreeNode(preorder[i]);
                        break;
                    }
                }
            }
        }
        return root;
    }


    //========solution_3=========
    //单函数递归构建
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode (int val){
            this.val = val;
        }
    }
}
