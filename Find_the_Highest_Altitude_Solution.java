public class Find_the_Highest_Altitude_Solution {
    public int largestAltitude(int[] gain) {
        // Road trip -> n+1 points at different altitudes
        // 0 + -5 = -5 => -5 + 1 = -4 => -4 + 5 = 1 => 1 + 0 = 1  => 1 + -7 => -6
        // 0, -5, -4, 1, 1, -6

        int initialAltitude = 0;
        int highest = 0;

        for(int element: gain) {
            if(initialAltitude + element > highest) {
                highest = initialAltitude + element;
            }
            initialAltitude += element;
        }
        return highest;
    }
}