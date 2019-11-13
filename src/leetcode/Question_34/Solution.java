package leetcode.Question_34;

/**
 * @Author: Liyong.liu
 * @Date: 2019/11/13 下午10:13
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0||target>nums[nums.length-1]||target<nums[0]){
            return new int[]{-1,-1};
        }
        int left = 0, right = nums.length-1,mid = left+ (right-left)/2;
        while(left<=right){
            if(nums[mid]==target){
                int i = mid;
                int j = mid;
                while(i-1>=left&&nums[i-1]==target){
                    i--;
                }
                while(j+1<=right&&nums[j+1]==target){
                    j++;
                }
                return new int[]{i,j};
            }else if(nums[mid]<=target){
                left = mid+1;
            }else{
                right = mid -1;
            }
            mid = left+ (right-left)/2;
        }
        return new int[]{-1,-1};
    }
}
