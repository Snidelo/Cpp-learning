package easy;

/**
 * 这个题是最简单的我觉得
 */
public class ToLowerCaseDemo {
    public static void main(String[] args){
        System.out.println(toLowerCase("Hello"));
    }

    public static  String toLowerCase(String str){
        char[] cs = str.toCharArray();
        for(int i = 0; i < cs.length; i ++){
            if(cs[i] >= 'A' && cs[i] <= 'Z'){
                cs[i] += 32;
            }
        }
        return new StringBuilder().append(cs).toString();
        //最后一行可以做一下优化，直接 return new String(cs);对库函数还是不够熟悉
    }
}
