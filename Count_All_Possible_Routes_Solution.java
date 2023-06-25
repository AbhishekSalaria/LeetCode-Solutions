public class Count_All_Possible_Routes_Solution {
    public int helper(int[] locations, int city, int finish, int remainingFuel, Integer[][] memory) {
        if(remainingFuel < 0 ) {
            return 0;
        }
        if(memory[city][remainingFuel] != null) {
            return memory[city][remainingFuel];
        }

        int total = city == finish ? 1:0;
        for(int nextCity = 0 ; nextCity < locations.length; nextCity++) {
            if(nextCity != city && remainingFuel >= Math.abs(locations[nextCity] - locations[city])) {
                total = (total + helper(locations, nextCity, finish,remainingFuel - Math.abs(locations[nextCity] - locations[city]),memory)) % 1000000007;
            }
        }
        return memory[city][remainingFuel] = total;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        Integer[][] memory = new Integer[n][fuel + 1];
        return helper(locations, start, finish, fuel, memory);
    }
}