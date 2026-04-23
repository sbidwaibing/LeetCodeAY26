class Solution {
    public int minOperations(int[] nums) {
        
        int count = 0;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(i % 2 == 0){
                while(!isPrime(num)){
                    num++;
                    count++;
                }
            }
            else{
                while(isPrime(num)){
                    num++;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isPrime(int x){
        if(x <= 1) return false;
        if(x <= 3) return true;

        if(x % 2 == 0 || x % 3 == 0){
            return false;
        }

        for(int i = 5; i * i <= x; i+=6){
            if(x % i == 0 || x % (i+2) == 0){
                return false;
            }
        }

        return true;
    }
}