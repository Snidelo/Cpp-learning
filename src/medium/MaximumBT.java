package medium;

public class MaximumBT {
    public static void main(String[] args) {
        new MaximumBT().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

    //===========solution_1============
    //这道题实际就是生成二叉树,只不过多了一个找最大值的操作
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //实际是处理i一个数组
        //find biggest
        //divide in two
        TreeNode root = findBiggest(nums, 0, nums.length - 1);
        return root;
    }



    public TreeNode findBiggest(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int biggest = 0;
        int divideIndex = 0;
        for(int i = left; i <= right; i++){
            if(biggest <= nums[i]){
                biggest = nums[i];
                divideIndex = i;
            }
        }

        TreeNode node = new TreeNode(biggest);
        node.left = findBiggest(nums, left, divideIndex - 1);
        node.right = findBiggest(nums, divideIndex + 1, right);
        return node;
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
