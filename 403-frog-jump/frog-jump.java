class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, Set<Integer>> dp = new HashMap<>();
        Set<Integer> stoneSet = new HashSet<>();
        for(int stone : stones){
            stoneSet.add(stone);
            dp.put(stone , new HashSet<>());
        }
        dp.get(0).add(0);
        for(int stone : stones){
            for(int k : dp.get(stone)){
                for(int step = k-1 ; step <= k+1 ; step++){
                    if(step > 0 && stoneSet.contains(stone + step)){
                        dp.get(stone + step).add(step);
                    }
                }
            }
        }
        return !dp.get(stones[n-1]).isEmpty();
    }
}