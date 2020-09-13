package leetcode.lee1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lee1 {

    public static void main(String[] args) {
        int[] nums = {13,24,3,53,6,78,21};
        int[] peers = twoSum(nums, 66);
        System.out.println("");
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int result = Math.abs(target-nums[i]);
            if(map.containsKey(result) && map.get(result)!=i){
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
