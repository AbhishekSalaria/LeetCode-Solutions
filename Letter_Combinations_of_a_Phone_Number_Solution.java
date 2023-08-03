import java.util.*;
public class Letter_Combinations_of_a_Phone_Number_Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,List<String>> map = new HashMap<>();
        map.put(2,Arrays.asList("a","b","c"));
        map.put(3,Arrays.asList("d","e","f"));
        map.put(4,Arrays.asList("g","h","i"));
        map.put(5,Arrays.asList("j","k","l"));
        map.put(6,Arrays.asList("m","n","o"));
        map.put(7,Arrays.asList("p","q","r","s"));
        map.put(8,Arrays.asList("t","u","v"));
        map.put(9,Arrays.asList("w","x","y","z"));

        List<String> result = new ArrayList<>();

        if(digits.length() == 1) {
            return map.get(Integer.parseInt(digits));
        }
        else if(digits.length() == 2) {
            String concat;
            for(String str1: map.get(Character.getNumericValue(digits.charAt(0)))) {
                for(String str2: map.get(Character.getNumericValue(digits.charAt(1)))) {
                    concat = str1 + str2;
                    result.add(concat);
                }
            }
        }
        else if(digits.length() == 3) {
            String concat;
            for(String str1: map.get(Character.getNumericValue(digits.charAt(0)))) {
                for(String str2: map.get(Character.getNumericValue(digits.charAt(1)))) {
                    for(String str3: map.get(Character.getNumericValue(digits.charAt(2)))){
                        concat = str1 + str2 + str3;
                        result.add(concat);
                    }
                }
            }
        }
        else if(digits.length() == 4) {
            String concat;
            for(String str1: map.get(Character.getNumericValue(digits.charAt(0)))) {
                for(String str2: map.get(Character.getNumericValue(digits.charAt(1)))) {
                    for(String str3: map.get(Character.getNumericValue(digits.charAt(2)))){
                        for(String str4: map.get(Character.getNumericValue(digits.charAt(3)))){
                            concat = str1 + str2 + str3 + str4;
                            result.add(concat);
                        }
                    }
                }
            }
        }
        return result;
    }
}