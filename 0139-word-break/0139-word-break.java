class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>();
        // Set<String> hs = new HashSet<>(wordDict); // you could directly feed the list to HashSet.
        
        // manually adding the elements of wordDict to the HashSet<>();
        for(String w : wordDict){
            hs.add(w);
        }

        int maxLen = 0;
        for(String w : wordDict){
            maxLen = Math.max(maxLen, w.length());
        }

        boolean[] ok = new boolean[s.length() + 1];
        ok[0] = true;

        for(int i = 1; i <= s.length(); i++){
            
            int start = Math.max(0, i - maxLen);
            
            for(int j = start; j < i; j++){
                
                if(ok[j] == true){
                    String piece = s.substring(j, i);
                    
                    if(hs.contains(piece)){
                        ok[i] = true;
                        break;
                    }
                }
            }
        }

        return ok[s.length()];

    }
}