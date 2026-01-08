class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);

        int maxLen = 0;
        for(String w : wordDict){
            maxLen = Math.max(maxLen, w.length());
        }

        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(0, s, hs, maxLen, memo);
    }

    public List<String> dfs(int start, String s, Set<String> hs, int maxLen, Map<Integer, List<String>> memo){
        if(memo.containsKey(start)){
            return memo.get(start);
        }

        List<String> res = new ArrayList<>();

        if(start == s.length()){
            res.add("");
            memo.put(start, res);
            return res;
        }

        int endLimit = Math.min(s.length(), start + maxLen);

        for(int end = start + 1; end <= endLimit; end++){
            String word = s.substring(start, end);

            if(!hs.contains(word)){
                continue;
            }

            List<String> tails = dfs(end, s, hs, maxLen, memo);
            for(String tail : tails){
                if(tail.isEmpty()){
                    res.add(word);
                }
                else{
                    res.add(word + " " + tail);
                }
            }
        }

        memo.put(start, res);
        return res;
    }
}