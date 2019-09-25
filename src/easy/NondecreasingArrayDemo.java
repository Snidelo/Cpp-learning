package easy;

public class NondecreasingArrayDemo {

    //brut人force
    //TODO: 需要重新理清思路，情况很多，[1,2,4,5,3]，[2,3,3,2,4],[3,4,2,3]
    //比如，找到了下降点，是改变下降点到前一个点，还是将下降点后的数值，改为下降点后两个数值，这样子的情况发生在数组首元素，数组中间，数组末尾等

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] < nums[i]){
                if(count == 1){
                    return false;
                }
                if(i == 0){
                    count++;
                    nums[i] = 0;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[i - 1];
                if(nums[i + 1] < nums[i]){
                    nums[i] = temp;
                    if(i < nums.length - 2){
                        nums[i + 1] = nums[i + 2];
                    }else{
                        return count != 1;
                    }
                }
                count++;
                i--;
            }
        }
        return true;
    }
}
