class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        Arrays.sort(costs , (a,b) -> (a[0]-a[1]) - (b[0]-b[1]));
        int res = 0;
        for(int i = 0 ; i < costs.length ; i++) {
            if(i < n){
                res += costs[i][0];
            }
            else{
                res += costs[i][1];
            }
        }
        return res;
    }
}