class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> mp;

    public RandomizedSet() {
        list = new ArrayList<>();
        mp = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)){
            return false;
            // System.out.println("Value already Exists");
        }
        else{
            list.add(val);
            mp.put(val, list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(mp.containsKey(val)){
            int idx = mp.get(val);
            int last = list.get(list.size() - 1);

            list.set(idx, last);
            mp.put(last, idx);

            list.remove(list.size() - 1);
            mp.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int val = rand.nextInt(list.size());
        return list.get(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */