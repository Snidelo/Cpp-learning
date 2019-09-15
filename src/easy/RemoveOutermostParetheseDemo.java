package easy;

import java.util.Stack;

public class RemoveOutermostParetheseDemo {
    public static void main(String[] args){
        System.out.println(new RemoveOutermostParetheseDemo().remove_1("(()())(())(()(()))"));
    }
//    public String remove(String S){
//        char[] C = S.toCharArray();
//        Stack<Character> cStack= new Stack<Character>();
//        StringBuilder sb = new StringBuilder();
//        char temp;
//        for(char c : C){
//            if(c == '('){
//                if(cStack.isEmpty()){
//                    cStack.push(c);
//                }else{
//                    sb.append(c);
//                }
//            }else{
//                if((sb.length() % 2) != 0){
//                    cStack.pop();
//                }else{
//                    sb.append()
//                }
//            }
//        }
//        return sb.toString();
//    }
    //=======solution_1=========
    //这道题一开始我想用栈结构或者队列做，但是如果不计数就无法判断是否是最外层的PS，或者是判断是外层的但是输出顺序不同。做不出来直接看答案。
    //

    public String remove(String S){
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }

    //=======solution_1=========
    //同样是solution_1，只是换了种判断方式
    public String remove_1(String S){
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c == '('){
                if(++open != 1){//说明此时括号是开的（等于0的时候括号是闭合的）
                    sb.append(c);
                }
            }
            if(c == ')'){
                if(--open != 0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
