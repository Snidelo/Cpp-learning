package easy;

import java.util.Stack;

public class RomanToIntegerDemo {
    public static void main(String[] args){
        System.out.println(romanToInt_2("MCMXCIV"));
    }

    //================solution_1==================
    //分析，这是一个结合了字符串和数字的题，因为罗马数字是通过符号前后附加来达到整值加减（例如IV表示4，VI表示6），所以暴力解法就是找出所有可能的搭配情况
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
    //CD CM ; XL XC; IV IX 前置情况只有这几种，用栈来操作？
    //考虑栈操作，如果栈空，则需要考虑新字符的后续字符，将新字符压入栈，如果栈非空，比较新字符与栈顶字符，相同，或者满足以上前置情况的话，
    public static int romanToInt_1(String s){
        Stack<Character> cStack = new Stack<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            //if stack is empty. push the new char
            if(cStack.isEmpty()){
                cStack.push(c);
            }else {//not empty, consider the relationship between this char and the char at top of the stack
                Character temp = cStack.pop();
                if(temp.equals(c))
                {
                    cStack.push(temp);
                    cStack.push(c);
                }else if((temp.equals('I') && (c.equals('V') ||c.equals('X')))){
                    cStack.push(c);
                    cStack.push(temp);
                    while(!cStack.isEmpty()){
                        temp = cStack.pop();
                        switch (temp){
                            case 'I':
                                res = res - 1;
                                break;
                            case 'V':
                                res = res + 5;
                                break;
                            case 'X':
                                res = res + 10;
                                break;
                        }
                    }
                }else if((temp.equals('X') && (c.equals('L') ||c.equals('C')))){
                    cStack.push(c);
                    cStack.push(temp);
                    while(!cStack.isEmpty()){
                        temp = cStack.pop();
                        switch (temp){
                            case 'X':
                                res = res - 10;
                                break;
                            case 'L':
                                res = res + 50;
                                break;
                            case 'C':
                                res = res + 100;
                                break;
                        }
                    }
                }else if((temp.equals('C') && (c.equals('M') ||c.equals('D')))){
                    cStack.push(c);
                    cStack.push(temp);
                    while(!cStack.isEmpty()){
                        temp = cStack.pop();
                        switch (temp){
                            case 'C':
                                res = res - 100;
                                break;
                            case 'D':
                                res = res + 500;
                                break;
                            case 'M':
                                res = res + 1000;
                                break;
                        }
                    }
                }else {//no relationship between c & temp, add temp, push c
                    cStack.push(temp);
                    while(!cStack.isEmpty()){
                        temp = cStack.pop();
                        switch (temp){
                            case 'I':
                                res = res + 1;
                                break;
                            case 'V':
                                res = res + 5;
                                break;
                            case 'X':
                                res = res + 10;
                                break;
                            case 'L':
                                res = res + 50;
                                break;
                            case 'C':
                                res = res + 100;
                                break;
                            case 'D':
                                res = res + 500;
                                break;
                            case 'M':
                                res = res + 1000;
                                break;
                        }
                    }
                    cStack.push(c);
                }
            }
        }

        while (!cStack.isEmpty()){
            switch (cStack.pop()){
                case 'I':
                    res = res + 1;
                    break;
                case 'V':
                    res = res + 5;
                    break;
                case 'X':
                    res = res + 10;
                    break;
                case 'L':
                    res = res + 50;
                    break;
                case 'C':
                    res = res + 100;
                    break;
                case 'D':
                    res = res + 500;
                    break;
                case 'M':
                    res = res + 1000;
                    break;
            }
        }
        return res;
    }
    //ATTENTION!
    //分析中有缺陷的地方，因为IIV，IIX，等是不存在的，只需要跟后一位比较就好，所以不需要栈操作，不会存在IIIIIV这样的情况

    //================solution_2==================
    //网上一个大佬的解法
    public static int romanToInt_2(String s){
        int result = 0;
        char[] digits = s.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 'I') {
                if (digits.length > i + 1) {
                    if (digits[i + 1] == 'V') {
                        result += 4;
                        i++;
                    } else if (digits[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result++;
                    }
                } else {
                    result++;
                }
            } else if (digits[i] == 'X') {
                if (digits.length > i + 1) {
                    if (digits[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if (digits[i + 1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
            } else if (digits[i] == 'C') {
                if (digits.length > i + 1) {
                    if (digits[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if (digits[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                } else {
                    result += 100;
                }
            } else if (digits[i] == 'V') {
                result += 5;
            } else if (digits[i] == 'L') {
                result += 50;
            } else if (digits[i] == 'D') {
                result += 500;
            } else if (digits[i] == 'M') {
                result += 1000;
            }
        }
        return result;
    }
}
