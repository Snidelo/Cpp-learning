package easy;

public class PalindromeNumberDemo {
    public static void main(String[] args){
        System.out.println(isPalindromeNumber_1(10));
    }

    //===================solution_1======================
    //利用ReverseIntegerDemo中的反转，来判断反转后的数字是否等于反转前的数字，如果数值超过了Integer的界限，只能用字符串的方式判断
    public static boolean isPalindromeNumber_1(int x){
        if(x < 0)
            return false;
        return new StringBuilder().append(x).reverse().toString().equals(x + "");
    }
}
