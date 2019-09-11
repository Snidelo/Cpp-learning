package easy;

public class ReverseIntegerDemo {
    public static void main(String[] args){
        System.out.println(reverse_3(1534236469) + "");
    }
    //=================solution_1===================
    //自己写的算法，通过将数转化成字符串数组进行处理
    // 分析其时间复杂度为O(2n)
    public static int reverse_1(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        String xString = new String("" + x);
        char[] xArr = new char[xString.length()];
        for(int i = 0; i < xArr.length; i++){
            xArr[i] = xString.charAt(i);
        }
        if(x >= 0){
            for(int i = xArr.length - 1; i >= 0; i--){
                stringBuilder.append(xArr[i]);
            }
            //return Integer.valueOf(stringBuilder.toString());
        }else{
            stringBuilder.append("-");
            for(int i = xArr.length - 1; i >= 1; i--){
                stringBuilder.append(xArr[i]);
            }
           // return Integer.valueOf(stringBuilder.toString());
        }
        try{
            if(stringBuilder.toString() != null && !(stringBuilder.toString() == "")){
                return Integer.valueOf(stringBuilder.toString());
            }else{
                return 0;
            }
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    //=================solution_2===================
    //自己写的，直接处理数字，利用取余获取每一位的值
    //需要加入判断是否越界了，
    public static int reverse_2(int x) {
        int reversedRes = 0;
        int bit = 0;
        try{while(Math.abs(x) > 0) {
            bit = x % 10;
            /*改进:在此处加入判断越界*/
            if(reversedRes > Integer.MAX_VALUE / 10 || reversedRes < Integer.MIN_VALUE / 10
            || (reversedRes == Integer.MAX_VALUE / 10 && bit > 7)
            || (reversedRes == Integer.MIN_VALUE / 10 && bit < -8)){
                return 0;
            }
            reversedRes = reversedRes * 10 + bit;
            x /= 10;
        }
            return reversedRes;
        }catch (Exception e){
            return 0;
        }
    }
    //=================solution_3===================
    //网上答案，转化为字符串，用自带的reverse方法
    public static int reverse_3(int x){
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try{
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    //=================solution_4===================
    //标准答案
    public static int reverse_4(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //在下一次合并数值之前判断是否越界，否则，如果越界，数值将被截断，无法判断越界
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
