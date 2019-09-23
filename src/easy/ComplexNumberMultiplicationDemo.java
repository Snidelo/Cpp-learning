package easy;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ComplexNumberMultiplicationDemo {

    //=========solution_1============
    public String complexNumberMultiply(String a, String b) {
        String[] A = a.split("\\+");
        A[1] = A[1].substring(0, A[1].length() - 1);
        String[] B = b.split("\\+");
        B[1] = B[1].substring(0,B[1].length() - 1);
        int reala = Integer.valueOf(A[0]);
        int imaga = Integer.valueOf(A[1]);
        int realb = Integer.valueOf(B[0]);
        int imagb = Integer.valueOf(B[1]);
        return new String(reala * realb - imaga * imagb + "+" + (realb * imaga + reala * imagb) + "i");
    }

    //=============solution_2==============
    //leetcoder 骚操作，还有一行的，就不抄了，差不多。
    //注意这里的split使用，正则表达式相关？“|”表示或？
    public String complexNumberMultiply_2(String a, String b) {
        int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
                coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
    }
}
