public class Zigzag_Conversion_Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            sb[i] = new StringBuilder();
        }

        char []arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        while(index < n) {
            for(int j = 0; j < numRows && index < n; j++) {
                sb[j].append(arr[index++]);
            }
            for(int j = numRows-2; j > 0 && index < n; j--) {
                sb[j].append(arr[index++]);
            }
        }

        StringBuilder result = sb[0];
        for(int i = 1; i< numRows; i++) {
            result.append(sb[i].toString());
        }
        return result.toString();
    }
}