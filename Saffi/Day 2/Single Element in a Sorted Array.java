class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums[0] != nums[1]) {
            return nums[0];
        }

        if(nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1]; 
        }

        int left = 1, right = nums.length - 2;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if((mid & 1) == 0) {
                if(nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                }
                else if(nums[mid] == nums[mid - 1]) {
                    right = mid - 1;
                }
            }
            else {
                if(nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                }
                else if(nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                }
            }
            
        }

        return 0;
    }
}