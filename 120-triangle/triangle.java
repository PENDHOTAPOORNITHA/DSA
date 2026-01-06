import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();

        for (int i = rows - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                int current = triangle.get(i).get(j);
                int down = triangle.get(i + 1).get(j);
                int downRight = triangle.get(i + 1).get(j + 1);

                int minBelow = Math.min(down, downRight);

                triangle.get(i).set(j, current + minBelow);
            }
        }

        return triangle.get(0).get(0);
    }
}
