class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];

            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement), i};
            }
            mp.put(nums[i], i);
        }
      
        return new int[]{};
    }
}