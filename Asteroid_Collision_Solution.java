public class Asteroid_Collision_Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stk = new Stack<>();

        for(int ast: asteroids) {
            if(ast > 0 || stk.isEmpty()) {
                stk.push(ast);
            }
            else{
                while(!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(ast)) {
                    stk.pop();
                }
                if(!stk.isEmpty() && stk.peek() == Math.abs(ast)) {
                    stk.pop();
                }
                else {
                    if(stk.isEmpty() || stk.peek() < 0) {
                        stk.push(ast);
                    }
                }
            }

        }
        int [] result = new int[stk.size()];
        for(int i = 0; i < stk.size(); i++) {
            result[i] = stk.get(i);
        }
        return result;
    }
}