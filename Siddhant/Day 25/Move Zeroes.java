class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int dup=nums[j];
                nums[j]=nums[i];
                nums[i]=dup;
                j++;
            }
        }
    }
}