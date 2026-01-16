class RandomizedSet {

    List<Integer> newList;
    Map<Integer, Integer> mp;

    public RandomizedSet() {
        newList = new ArrayList<>();
        mp = new HashMap<>();
    }
    
    public boolean insert(int val) {
        int index = 0;
        
        if(mp.containsKey(val)){
            return false;
        }
        else{
            newList.add(val);
            mp.put(val, newList.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(mp.containsKey(val)){
            int firstValue = mp.get(val);
            int lastValue = newList.get(newList.size()-1);

            newList.set(firstValue, lastValue);
            mp.put(lastValue, firstValue);

            newList.remove(newList.size()-1);
            mp.remove(val);

            return true;
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        Random rnd = new Random();
        int val = rnd.nextInt(newList.size());
        return newList.get(val);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */