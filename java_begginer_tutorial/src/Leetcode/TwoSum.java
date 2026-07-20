package Leetcode;

import java.util.Arrays;

public class TwoSum {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{3, 3, 7, 20, 9, 1}, 21)));

    }


    public static int[] twoSum(int[] nums, int target) {
        int [] indexes = new int [2];
        int  k,  index = 0;

        for (k = 0; k < nums.length; k++){
            int j = k + 1;
            for (;j < nums.length; j++){
                if ((nums[k] + nums[j]) == target){
                    indexes[0] = k;
                    indexes[1] = j;
                }
            }
            j = k + 1;
        }
     return indexes;

    }
}
