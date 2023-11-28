package com.isoft;

public class TryDemo {

    public static void main(String[] args) {
        int []nums={10,9,8,7,6,5,4,3,2,1};
        int[] ints = orderBy(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] orderBy(int[] nums){
        int numLength = nums.length;
        int j = 0;
        int [] nums2 = new int[numLength];
        for (int i = numLength-1; i >=0; i--) {
            if (j<numLength){
                nums2[j++] = nums[i];
            }
        }
        return nums2;
    }
}

