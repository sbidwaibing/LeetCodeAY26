class Solution {
    
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
       
        memo.put(1, 0);

        List<Integer> nums = new ArrayList<>();
        
        for(int i = lo; i <= hi; i++){
            nums.add(i);
        }

        nums.sort((a,b) ->{
            int pa = power(a);
            int pb = power(b);

            if(pa != pb){
                return Integer.compare(pa, pb);
            }
            return Integer.compare(a,b);
        });

        return nums.get(k-1);
        
    }

    public int power(int x){
        
        if(memo.containsKey(x)){
            return memo.get(x);
        }
        
        int next;
        
        if(x % 2 == 0){
            next = (x / 2);
        }
        else{
            next = ((3 * x) + 1);
        }
        
        int ans = 1 + power(next);
        memo.put(x, ans);

        return ans;
    }
}