import java.util.*;

public class Longest_Substring_3 {
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0){
            return 0;
        }

        HashSet<Character> mySet = new HashSet<>();

        int left = 0, right = 0;
        int max = 0;

        while(right < s.length())
        {
            char ch = s.charAt(right);

            if(!mySet.contains(ch))
            {
                mySet.add(ch);
                right++;
                max = Math.max(max, mySet.size());
            }
            else
            {
                mySet.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
       String s = "abcabcbb";
       int length = lengthOfLongestSubstring(s);
       System.out.println(length);
    }
}
