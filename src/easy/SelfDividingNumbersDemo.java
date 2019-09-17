package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbersDemo {
    public static void main(String[] args) {
        System.out.println(new SelfDividingNumbersDemo().selfDividingNumber(1,22));

    }

    //===============solution_1==============
    public List<Integer> selfDividingNumber(int left, int right){
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i = left, num = left; i <= right; num = ++i){
            for(int j = 0; j < (i + "").length(); j++){
                if(num % 10 == 0 || i % (num % 10) != 0){
                    break;
                }
                num /= 10;
                count ++;
            }
            if(count == (i + "").length()){
                res.add(i);
            }
            count = 0;
        }
        return res;
    }

    //===============solution_2==============
    //solution_1的内层循环的判断条件可以再进行优化，
    public List<Integer> selfDividingNumber_2(int left, int right){
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i = left, n = 0; i <= right; ++i){
            for (n = i; n > 0; n /= 10)
                if (n % 10 == 0 || i % (n % 10) != 0)
                    break;
            if (n == 0)
                res.add(i);
        }
        return res;
    }
}
