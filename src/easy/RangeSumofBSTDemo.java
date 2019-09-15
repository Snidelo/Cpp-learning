package easy;


import java.util.Stack;

/**
 * 这道题比较简单，主要是要搞清楚题意和二叉排序树的特点
 */
public class RangeSumofBSTDemo {
    private static int sum = 0;
    public static void main(String[] args) {
        System.out.println("" + sum);
    }



    //==================solution_1=================
    //遍历二叉树，如果遍历到的值在L,R的范围内就加上，否则跳过
    public static int RangeSum_1(Node root, int L, int R){
        sum = 0;
        if(root == null){
            return -1;
        }
        inOrder(root, L, R);
        return sum;
    }

    public static void inOrder(Node node, int L, int R){
        if(node.left != null){
            inOrder(node.left, L, R);
        }
        if(node.right != null){
            inOrder(node.right, L, R);
        }
        if(node.value <= R && node.value >= L){
            sum += node.value;
        }
    }

    //==================solution_2=================
    //题目要求的是二叉排序树，所以solution1 没有利用到他排序的特点，速度比较慢
    public static int RangeSum_2(Node root, int L, int R){
        sum = 0;
        if(root == null){
            return -1;
        }
        inOrder_2(root, L, R);
        return sum;
    }

    public static void inOrder_2(Node node, int L, int R){
        if(node.value <= R && node.value >= L){
            sum += node.value;
        }
        if(node.value > L){
            inOrder_2(node.left, L, R);
        }
        if(node.value < R){
            inOrder_2(node.right, L, R);
        }
    }

    //==================solution_3=================
    //递归的题大多能用栈结构解决，solution_2用空间换时间（(Java) Recursive method executes less instructions and function calls in exchange for occupying more memory space in stack）
    public static int RangeSum_3(Node root, int L, int R) {
        sum = 0;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            Node node = nodeStack.pop();
            //直接照下面这样写有漏洞，如果node为空，那么有空指针异常，所以要在此处判定当前node是否为空
            if(node.value <= R && node.value >= L){
                sum += node.value;
            }
            if(node.value > L){
                nodeStack.push(node.left);
            }
            if(node.value < R){
                nodeStack.push(node.right);
            }
        }
        return sum;
    }
}

class Node{
    Node left;
    Node right;
    int value;
    public Node(int x){this.value = x;}
}
