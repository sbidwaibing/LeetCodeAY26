class MagicDictionary {

    public String[] data;
    
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        this.data = dictionary;
    }
    
    public boolean search(String searchWord) {
        for(String element : data){
            if(onlyDiff(element, searchWord)){
                return true;
            }
        }
        return false;
    }

    public boolean onlyDiff(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        
        int diffCount = 0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diffCount++;

                if(diffCount > 1){
                    return false;
                }
            }
        }

        return diffCount == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */