public class Work_Break_Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] track = new boolean[s.length()+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        while(!queue.isEmpty()){
            int start = queue.poll();

            if(start == s.length()) {
                return true;
            }
            for(int end = start + 1; end <= s.length(); end++){
                if(track[end]){
                    continue;
                }
                if(wordDict.contains(s.substring(start, end))) {
                    queue.add(end);
                    track[end] = true;
                }
            }
        }
        return false;
    }
}