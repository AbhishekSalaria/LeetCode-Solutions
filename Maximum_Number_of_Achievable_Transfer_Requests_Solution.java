public class Maximum_Number_of_Achievable_Transfer_Requests_Solution {
    public int maximumRequests(int n, int[][] requests) {
        for(int k = requests.length; k > 0; k--) {
            List<List<Integer>> combinations = getCombinations(requests.length, k);

            for(List<Integer> current: combinations) {
                int[] degree = new int[n];
                for(int i: current){
                    degree[requests[i][0]]--;
                    degree[requests[i][1]]++;
                }
                if(allZeros(degree)) {
                    return k;
                }
            }
        }
        return 0;
    }

    private List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), 0, n, k);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> current, int start, int n, int k) {
        if(k == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i < n; i++) {
            current.add(i);
            backtrack(combinations, current, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }

    private boolean allZeros(int[] degrees) {
        for(int degree: degrees) {
            if(degree != 0) {
                return false;
            }
        }
        return true;
    }
}