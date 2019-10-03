package medium;

public class FlipEquivalentBTDemo {


    //=======solution_1=======
    public boolean flipEquiv_1(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 != null && root2 !=null) {
            if (root1.val != root2.val) { //如果根结点不相等,直接false;
                return false;
            }
        }else{
            return false;
        }
        return inOrder(root1, root2);
    }

    public boolean inOrder(TreeNode radix, TreeNode change){

        if(radix.left == null && radix.right == null) {//左右结点存在空结点的情况,要么向左或向右递归,要么返回
            if(change.left == null && change.right == null){
                return true;
            }else{
                return false;
            }
        }else if(radix.left != null && radix.right != null){//两个都不空
            //change 只要有一个为空,就false
            if(change.left == null || change.right == null){
                return false;
            }else{
                //如果左结点不同,交换再判断
                if(radix.left.val != change.left.val){
                    //flip operation
                    TreeNode temp = change.left;
                    change.left = change.right;
                    change.right = temp;
                    //如果还是不同,直接返回false;
                    if(radix.left.val != change.left.val){
                        return false;
                    }
                    //flip后相同了,跳出判断语句块,向下地递归
                }else if(radix.left.val == change.left.val && radix.right.val == change.right.val){//另一种情况:当前结点的左右结点对应相同
                    //什么都不做,跳出判断语句块,向下递归

                }else{//另一种情况,只有一个结点相同,必然不满足
                    return false;
                }
                return inOrder(radix.left, change.left) || inOrder(radix.right, change.right);// 左递归||右递归
            }
        }else{
            return (radix.left == null && change.left == null) && (radix.right.val == change.right.val) ||
                    (radix.right == null && change.left == null) && (radix.left.val == change.right.val) ||
                    (radix.left == null && change.right == null) && (radix.right.val == change.left.val) ||
                    (radix.right == null && change.right == null) && (radix.left.val == change.left.val);
        }
    }

    //==solution_2==
    //solution_1 是错的
    public boolean flipEquiv_2(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv_2(root1.left, root2.left) && flipEquiv_2(root1.right, root2.right) ||
                flipEquiv_2(root1.left, root2.right) && flipEquiv_2(root1.right, root2.left));
    }
}


class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}