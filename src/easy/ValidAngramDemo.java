package easy;

import java.util.Arrays;

public class ValidAngramDemo {

    //=========solution_1==========
    //用hashtable也可以解决，这里情况比较特殊，和之前有一题差不多，包含的元素范围是26个字母，所以可以用这种方法
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] letters = new int[26];

        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            letters[s.charAt(i++) - 97]++;
            letters[t.charAt(j++) - 97]--;
        }
        while(i < s.length()){
            letters[s.charAt(i++) - 97]++;
        }
        while(j < t.length()){
            letters[t.charAt(j++) - 97]--;
        }

        for(int a : letters){
            if(a != 0)
                return false;
        }
        return true;
    }

    //====solution_2=====
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


}
