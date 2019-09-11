package easy;

public class PalindromeNumberDemo {
    public static void main(String[] args){
        System.out.println(isPalindromeNumber_2(2147483647));
    }

    //===================solution_1======================
    //自己写的
    //利用ReverseIntegerDemo中的反转，来判断反转后的数字是否等于反转前的数字，如果数值超过了Integer的界限，只能用字符串的方式判断
    public static boolean isPalindromeNumber_1(int x){
        if(x < 0)
            return false;
        return new StringBuilder().append(x).reverse().toString().equals(x + "");
    }

    //===================solution_2======================
    //自己写的，同样是利用字符串，创建两个索引，从头和从尾部索引String类型的值，遇到不同则退出
    public static boolean isPalindromeNumber_2(int x){
        String xString = "" + x;
        int headIndex = 0;
        int tailIndex = xString.length();
        while(tailIndex > headIndex){//如果相等，则表明数值位数是奇数，且在当前两个索引指向中间的位，不影响反转，忽略
            if(xString.charAt(headIndex++) != xString.charAt(tailIndex--)){
                return false;
            }
        }
        return true;
    }

    //===================solution_2======================
    //网上答案，数学方法，例如1234321；将后面3位反转，并和高3位比较，相等则为Palindrome Number
    public static boolean isPalindromeNumber_3(int x){
        //情况说明，当一个数字小于0，或以0为个位，则不可能为Palindrome Number
        if(x == 0)
            return true;
        if(x < 0 || x % 10 == 0){
            return false;
        }
        int reversed = 0;
        while(x > reversed){
            reversed = reversed * 10 + x / 10;
            x = x / 10;
        }
        //跳出循环，说明此时x位数等于（x有偶数位）或小于（x有奇数位）reversed
        //如果x是偶数位，那么直接比较x和reversed是否相等，如果x是奇数位，那么此时reversed比x多一位（例如1234321，此时的情况是x=123，reversed=1234）而多的一位是中间位，不影响是否为palindromenumber 的判断，直接忽略
        return x == reversed || x == reversed / 10;
    }

}
