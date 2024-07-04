package org.example.algorithms.array;

import java.util.Arrays;

/**
 * Input: nums = [1,2,3,4]<p>
 * Output: [1,3,6,10]<p>
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class RunningSumOf1DArray {

    public static int[] myRunningSum(int[] nums) {
        int previous = 0;
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            previous = previous + element;
            results[i] = previous;
        }
        return results;
    }

    // time complexity = O(n)
    // space complexity = O(1)
    public static int[] solutionOneRunningSum(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            results[i] = nums[i] + results[i - 1];
        }

        return results;
    }

    public static int[] solutionTwoRunningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //nums[i] = nums[i - 1] + nums[i];
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        var result = myRunningSum(array);
        System.out.println(Arrays.toString(result));
    }
}
