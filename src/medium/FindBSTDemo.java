package medium;


public class FindBSTDemo {
    public static void main(String[] args) {
        float[] A = new float[]{1,2,1};
    }

    private int length = 0;
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    /*
    //==========solution_1===========
    public TreeNode findBST(int N){

        if((N - 1) % 2 != 0){
            return null;
        }
        length = N - 1;
        TreeNode root = new TreeNode(0);
        find(root);
    }

    public TreeNode find(TreeNode node){
        length /= 2;
        if(length != 1){
            node.left = new TreeNode(0);
        }

    }*/
}

