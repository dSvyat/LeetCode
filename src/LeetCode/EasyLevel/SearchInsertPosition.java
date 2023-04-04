package LeetCode.EasyLevel;


/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1] == target) return nums.length-1;
        if (nums[nums.length-1] < target) return nums.length;
        if (nums[0] > target) return 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == target){
                return i;
            }
            if (nums[i] < target && nums[i+1] > target){
                return i+1;
            }
        }
        return 0;
    }
}
