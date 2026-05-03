class Solution {
    
    private int ptr = 0;

    private StringBuilder dfs(String s){
        
        int count = 0;
        StringBuilder res = new StringBuilder();

        while(ptr < s.length()){
            char ch = s.charAt(ptr);

            if(Character.isDigit(ch)){
                count = count * 10 + (ch -'0');
            }
            else if(ch == '['){
                ptr++;
                StringBuilder nested = dfs(s);

                while(count > 0){
                    res.append(nested);
                    count--;
                }
            }
            else if(ch ==']'){
                return res;
            }
            else{
                res.append(ch);
            }
            ptr++;
        }

        return res;
    }
    
    public String decodeString(String s) {
        return dfs(s).toString();
    }
}