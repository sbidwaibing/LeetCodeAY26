import java.util.Stack; 

class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> st = new Stack<>();
        int score = 0;

        for(String opr : operations){
            
            if(opr.equals("+")){
                int n1 = st.pop();
                int sum = n1 + st.peek();

                st.push(n1);
                st.push(sum);
            }
            else if(opr.equals("C")){
                st.pop();
            }
            else if(opr.equals("D")){
                st.push(2 * st.peek());
            }
            else{
                st.push(Integer.parseInt(opr));
            }
        }

        while(!st.isEmpty()){
            score += st.pop();
        }

        return score;
    }
}