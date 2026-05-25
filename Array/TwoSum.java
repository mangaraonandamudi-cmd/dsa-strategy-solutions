/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // First try to identify the answers for these questions
        /*
             I have prepared the answers based on the below constrainits, but you need to confirm these with the interviewer
             if those are not mentioned

             1) is the Array is sorted -- NO
             2) how big the array is? -- it can be thousans and millions of data
                    so sorting and maintaining the o(nlogn) + o(n) , so it is not optimized solution
             3) can it have negetive values?  Yes
             4) is it possible to have multiple answers exists ?  NO


             Constraints:

                    2 <= nums.length <= 104
                    -109 <= nums[i] <= 109
                    -109 <= target <= 109
                    Only one valid answer exists.

        */
        if(nums == null || nums.length == 0 ) return new int[2];
        int n = nums.length;
        // create the map and store the "value" as key and "index" as value in the map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n ;i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}