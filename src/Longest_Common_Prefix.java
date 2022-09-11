import java.util.Arrays;
import java.util.HashSet;

public class Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs) {
        // The idea is the longest common prefix must contain each string component as well
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
}
