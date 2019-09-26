package easy;

//#389
public class FindDifferenceDemo {
    //这道题还是一道两个字符串的匹配题，还是可以用int[] a = new int[26]，来做

    //=====solution_1======
    public char findTheDifference_1(String s, String t) {
        int[] letters = new int[26];
        for(char ele : s.toCharArray()){
            letters[ele - 'a']++;
        }
        for(char ele : t.toCharArray()){
            if(letters[ele - 'a'] == 0){
                return ele;
            }
            letters[ele - 'a']--;
        }

        return 'a';
    }

    //=====solution_2=====
    //网上的另一种解法，通过异或运算，适用于正常值固定出现两次，异常值出现奇数次的情况
    //另外有一个关于简化运算符的小问题：
    // for res = res ^ num1, the right side is evaluated as int and can not be assigned to a char; for res ^= num1, the right side is char
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
