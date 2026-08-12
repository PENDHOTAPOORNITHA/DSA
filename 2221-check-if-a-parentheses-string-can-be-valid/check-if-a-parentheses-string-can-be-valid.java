class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if(len%2 != 0)  return false;
        int zeros = 0, open = 0;
        for(int i = 0 ; i < len ; i++){
            if(locked.charAt(i) == '0'){
                zeros++;
            }
            else if(s.charAt(i) == '('){
                open++;
            }
            else{
                if(open > 0)    open--;
                else if(zeros > 0)  zeros--;
                else{
                    return false;
                }
            }
        }
        int closed = 0;
        zeros = 0;
        for(int i = len - 1 ; i >= 0 ; i--){
            if(locked.charAt(i) == '0'){
                zeros++;
            }
            else if(s.charAt(i) == ')'){
                closed++;
            }
            else{
                if(closed > 0)  closed--;
                else if(zeros > 0)  zeros--;
                else{
                    return false;
                }
            }
        }
        return true;
    }
}