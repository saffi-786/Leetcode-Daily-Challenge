class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans[] = new int[2];

        int left = 0, right = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);

                break;
            }

            map.put(nums[i], i);
        }

        return ans;
    }
}