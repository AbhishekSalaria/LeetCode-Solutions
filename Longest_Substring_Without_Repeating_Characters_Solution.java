import java.util.*;
public class Longest_Substring_Without_Repeating_Characters_Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<Character>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        if(s.length() == 1) {
            return 1;
        }
        while(i < s.length()) {
            if(j >= s.length()) {
                if(maxCount < chars.size()) {
                    maxCount = chars.size();
                }
                break;
            }
            if(chars.contains(s.charAt(j))) {
                if(maxCount < chars.size()) {
                    maxCount = chars.size();
                }
                chars = new HashSet<Character>();
                i += 1;
                j = i;
            }
            else {
                chars.add(s.charAt(j));
                j += 1;
            }
        }
        return maxCount;
    }
}
