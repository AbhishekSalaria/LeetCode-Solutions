public class Frog_Jump_Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> states = new HashMap<>();
        for(int i = 0; i < stones.length; i++) {
            states.put(stones[i],new HashSet<>());
        }

        states.get(stones[0]).add(1);

        for(int i = 0; i < stones.length; i++) {
            HashSet<Integer> jumps = states.get(stones[i]);

            for(int jump: jumps) {
                int nextState = stones[i] + jump;
                if(nextState == stones[stones.length - 1]) {
                    return true;
                }
                if(states.containsKey(nextState) == true) {
                    if(jump > 0){
                        states.get(nextState).add(jump - 1);
                    }
                    states.get(nextState).add(jump);
                    states.get(nextState).add(jump + 1);
                }
            }
        }
        return false;
    }
}
