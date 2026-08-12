class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Set<Integer> set = new HashSet<>();
        int balance = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                balance++;
            }
            else if(s.charAt(i) == ')'){
                if(balance==0){
                    set.add(i);
                }
                else{
                    balance--;
                }
            }
        }
        balance = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == ')'){
                balance++;
            }
            else if(s.charAt(i) == '('){
                if(balance == 0){
                    set.add(i);
                }
                else{
                    balance--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}