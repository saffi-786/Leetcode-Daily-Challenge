class Solution {
    public boolean search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(nums[mid]==target)
            {
                return true;
            }
            else if(nums[i]==nums[mid] && nums[mid]==nums[j])
            {
                i++;
                j--;
                continue;
            }
            else if(nums[i]<=nums[mid])
            {
                if(target>=nums[i] && target<=nums[mid])
                {
                    j=mid-1;
                }
                else
                {
                    i=mid+1;
                }
            }
            else
            {
                if(target>=nums[mid] && target<=nums[j])
                {
                    i=mid+1;
                }
                else
                {
                    j=mid-1;
                }
            }
        }
        return false;
    }
}