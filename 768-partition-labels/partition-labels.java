class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int last[] = new int[26];
        Arrays.fill(last , -1);
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            last[ch - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            end = Math.max(end , last[ch-'a']);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}