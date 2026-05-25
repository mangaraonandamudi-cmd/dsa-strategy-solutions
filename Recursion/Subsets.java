
/*

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if(i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        helper(nums, i+1, list, result);

        list.add(nums[i]);
        helper(nums, i+1, list, result);
        list.remove(list.size() - 1);
    }
}