public class Buddy_Strings_Solution {
    public boolean buddyStrings(String s, String goal) {
        int s_len = s.length();
        int g_len = goal.length();

        List<Character> list = new ArrayList<>();

        if(s_len != g_len) {
            return false;
        }
        if(s_len == 2) {
            if(s.equals(goal)) {
                if(s.charAt(0) == s.charAt(1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if(s.charAt(0) == goal.charAt(1) && s.charAt(1) == goal.charAt(0)) {
                    return true;
                }
            }
        }

        if(s.equals(goal)) {
            for(int i = 0; i < s_len; i++) {
                if(list.contains(s.charAt(i))) {
                    return true;
                }
                else {
                    list.add(s.charAt(i));
                }
            }
        }

        int count = 0;
        int first = 0;
        int second = 0;
        boolean ans = false;
        for(int i = 0; i < s_len; i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(count == 0) {
                    first = i;
                    count++;
                }
                else if(count == 1) {
                    if(s.charAt(first) == goal.charAt(i) && s.charAt(i) == goal.charAt(first)) {
                        ans = true;
                    }
                    count++;
                }
                else if(count >= 2) {
                    return false;
                }
            }
        }
        if(ans == true) {
            return true;
        }
        return false;
    }
}