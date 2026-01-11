class Solution {
    public int minimumSize(int[] nums, int maxOpr) {
        int left = 1;
        int right = 0;

        for(int num : nums){
            right = Math.max(right, num);
        }

        while(left < right){
            int mid = (left + right) / 2;
            if(isPossible(mid, nums, maxOpr)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isPossible(int maxBallsInBag, int[] nums, int maxOpr){
        int totalOperations = 0;
        
        for(int i=0; i<nums.length; i++){
           totalOperations += (nums[i] - 1) / maxBallsInBag;

            if(totalOperations > maxOpr){
                return false;
            }
        }
    
        return true;
    }
}