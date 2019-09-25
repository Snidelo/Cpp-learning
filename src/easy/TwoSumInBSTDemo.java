package easy;

import java.util.*;

public class TwoSumInBSTDemo {

    //soluyion_1
    //之前做两个和的问题时用的是hashset，像这种寻求匹配对象（存在性）的，都可以用hashset来组（如果要定量，也可以用hashmap做，次数为值，对象为key）
    private HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        //not null
        if(set.contains(k - root.val)){
            return true;
        }else{
            set.add(root.val);
            return findTarget(root.right, k) || findTarget(root.left, k);//注意这个返回语句的写法
        }
    }

    //======solution_2======
    //BFS + HashSet
    //将node保存在一个队列中，每次取一个，取完观察完后，保存其左右节点，如此循环
    public boolean findTarget_2(TreeNode root, int k){
        Set< Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }


    //====solution_3====
    //中序遍历并加到数组中，再用双指针来计算
    public boolean findTarget_3(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List< Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}