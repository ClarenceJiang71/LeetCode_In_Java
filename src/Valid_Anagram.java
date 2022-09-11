import java.util.HashMap;
import java.util.HashSet;

public class Valid_Anagram {

//    //Default, straightforward brutal force method
//    public static boolean isAnagram(String s, String t){
//        // 0. Collect occurrence information of String s,
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))){
//                map.put(s.charAt(i), 1);
//            }
//            else {
//                map.put(s.charAt(i), map.get(s.charAt(i))+1);
//            }
//        }
//
//        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
//        // 1. Check if a character in t does not even appear in s,
//        for (int i = 0; i < t.length(); i++) {
//            if (s.indexOf(t.charAt(i))==-1){
//                return false;
//            }
//            else {
//                if (!map2.containsKey(t.charAt(i))){
//                    map2.put(t.charAt(i), 1);
//                }
//                else {
//                    if(map2.get(s.charAt(i))+1>map.get(s.charAt(i))){
//                        return false;
//                    }
//                    map2.put(s.charAt(i), map2.get(s.charAt(i))+1);
//
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isAnagram(String s, String t){
        // Saves lots of space, but not running time.
        if (s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (!map.containsKey(first)){
                map.put(first, 1);
            }
            else{
                map.put(first, map.get(first)+1);
            }
            if (!map.containsKey(second)){
                map.put(second, -1);
            }
            else {
                map.put(second, map.get(second)-1);
            }
        }

        for ( Integer value: map.values()) {
            if ( value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
