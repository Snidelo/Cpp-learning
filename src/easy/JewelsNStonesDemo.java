package easy;

/**
 * 一道好题，solution_2的解法思想很常用
 */
public class JewelsNStonesDemo {
    public static void main(String[] args) {
        System.out.println(""+ JewelNStone_1("asd", "asddfgkjsdfehasdjfdnaasdhfkaj"));
    }

    //=====================solution_1=======================
    //拆开J,再去S中匹配，计数。显然时间复杂度是O(S*N)
    public static int JewelNStone_1(String J, String S){
        int num = 0;
        char[] C = J.toCharArray();
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < S.length(); j++){
                if(C[i] == S.charAt(j))
                    num++;
            }
        }
        return num;
    }

    //ATTENTION!!!
    //=====================solution_2=======================
    //discuss sector中的一个答案，因为固定的'a' - 'z', 'A' - 'Z' 对应了52个ASCII码，中间有6个符号，总共58个组成了连续的65-123的ASCII码
    //检索J，在对应的字符位置自加，代表对应的字符是jewel
    //检索S，如果对应的字符是jewel，则sum会加上1，否则加0;

    //显然这段代码的时间复杂度是O(S+N)(两个循环)，空间复杂度为O(1)，创建了一个常数长度的数组
    public static int JewelNStone_2(String J, String S){
        int[] stoneNum = new int[58];
        for (char stone : J.toCharArray()) {
            stoneNum[stone - 65]++;
        }

        int sum = 0;
        for (char jewel : S.toCharArray()) {
            sum += stoneNum[jewel - 65];
        }

        return sum;
    }

}
