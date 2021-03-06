package easy;

public class ReverseLinkedListDemo {



    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(6);
        ListNode four = new ListNode(8);
        ListNode five = new ListNode(12);
        ListNode six = new ListNode(9);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        ReverseLinkedListDemo demo = new ReverseLinkedListDemo();
        demo.solution_1(head);
    }


    //=========solution_1==========
    //recursion
    private ListNode tempHead = null;//ATTENTION 这个一定得写在外面,因为递归的时候会把当前的状态压入栈，如果递归结束，修改了某些栈中的变量，那么回到当前位置的时候，栈中的变量修改前的值会覆盖修改后的值
    public ListNode solution_1(ListNode head){

        if(head == null || head.next == null){
            return head;
        }else{
            //ListNode tempHead = null;  recusion(head, tempHead)这是不行的在最后一次递归修改了tempHead之后，上一层递归又会为空，解释见上
            recursion(head);
            head.next = null;//不要忘记把第一个结点的下一个结点置null，否则会形成一个环
            return tempHead;
        }
    }
    public void recursion(ListNode node){
        if(node.next.next != null) {
            recursion(node.next);
        }
        if(node.next.next == null){
            tempHead = node.next;
        }
        node.next.next = node;
    }


    //=======solution_2========
    public ListNode solution_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = solution_2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
