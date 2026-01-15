class Solution {
    
    private static final class Txn{
        
        final int time;
        final int amount;
        final String city;
        final int index;

        Txn(int time, int amount, String city, int index){
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.index = index;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;

        Map<String, List<Txn>> mp = new HashMap<>();
        boolean[] badTransactions = new boolean[n];
        List<String> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] p = transactions[i].split(",");
            
            String name = p[0];
            int time = Integer.parseInt(p[1]);
            int amount = Integer.parseInt(p[2]);
            String city = p[3];

            if(amount > 1000){
                badTransactions[i] = true;
            }

            mp.computeIfAbsent(name, k -> new ArrayList<>()).add(new Txn(time, amount, city, i));
        }

        for(List<Txn> tranList : mp.values()){
            tranList.sort(Comparator.comparingInt(t -> t.time));
        
            int m = tranList.size();

            for(int i=0; i<m; i++){
                Txn a = tranList.get(i);
                
                for(int j=i-1; j>= 0; j--){
                    Txn b = tranList.get(j);
                    
                    if(a.time - b.time > 60){
                        break;
                    }

                    if(!a.city.equals(b.city)){
                        badTransactions[a.index] = true;
                        badTransactions[b.index] = true;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(badTransactions[i]){
                result.add(transactions[i]);
            }
        }

        return result;
    }
}