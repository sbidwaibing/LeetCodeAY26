class Solution {
    public int reverse(int x) {

        long reverse = 0;

        while(x != 0){
            int popped = x % 10;
            x = x / 10;
            reverse = reverse * 10 + popped;

            if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
                return 0;
            }
        }

        return (int)reverse;
    }
}