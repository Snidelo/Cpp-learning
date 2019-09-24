package easy;

import java.util.HashSet;

public class InterSectionOfTwoArrayDemo {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        if(nums1.length > nums2.length){
            for(int a : nums1)set.add(a);
            for(int b : nums2){
                if(set.contains(b)){
                    res.add(b);
                }
            }
        }else{
            for(int a : nums2)set.add(a);
            for(int b : nums1){
                if(set.contains(b)){
                    res.add(b);
                }
            }
        }
        int[] resArr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            resArr[i] = (int)res.toArray()[i];
        }
        return resArr;
    }
}
