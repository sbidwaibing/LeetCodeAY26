class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++){
            
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            left++;
            right--;

            if(right - left > end - start){
                start = left;
                end = right;
            }

            left = i;
            right = i+1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            left++;
            right--;

            if(right - left > end - start){
                start = left;
                end = right;
            }

        }
        return s.substring(start, end + 1);
    }
}