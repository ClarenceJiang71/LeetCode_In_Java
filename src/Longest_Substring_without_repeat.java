import java.util.HashMap;

public class Longest_Substring_without_repeat {
    public static int lengthOfLongestSubstring(String s) {

        if (s.equals("")){return 0;}
        if (s.length() == 1) {return 1;}

        HashMap<Character, Integer> map = new HashMap<>();
        int startPoint = 0;
        int longestLength = 1;

        for (int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c, i);
                int length = i-startPoint+1;
                if (length > longestLength){
                    longestLength = length;
                }
            }
            else{
                int length = i-startPoint;
                if (map.get(c) < startPoint){
                    length++;
                }
                else{
                    startPoint = map.get(c) + 1;
                }
                map.put(c, i);
                if (length > longestLength){
                    longestLength = length;
                }
//                startPoint = map.get(c) + 1;
//                map.put(c, i);
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
