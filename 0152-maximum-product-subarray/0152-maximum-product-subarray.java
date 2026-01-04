class Solution {
    public int maxProduct(int[] nums) {
        
        int result = nums[0];
        int lpr = 1;
        int rpr = 1;

        for(int i = 0; i < nums.length; i++){
            rpr *= nums[i];
            result = Math.max(result, rpr);
            if(rpr == 0){
                rpr = 1;
            }
        }

        for(int i = nums.length - 1; i >= 0; i--){
            lpr *= nums[i];
            result = Math.max(result, lpr);
            if(lpr == 0){
                lpr = 1;
            }
        }

        return result;
    }
}
