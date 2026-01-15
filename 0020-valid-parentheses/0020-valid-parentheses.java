class Solution {
    public boolean isValid(String s) {
        Stack<Character> resultStack = new Stack<>();
        boolean ans = false;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                resultStack.push(')');
            }
            else if(ch == '['){
                resultStack.push(']');
            }
            else if(ch == '{'){
                resultStack.push('}');
            }
            else
            {
                if(resultStack.isEmpty() || resultStack.pop() != ch){
                    return false;
                }
            }
        }
        return resultStack.isEmpty();
    }
}