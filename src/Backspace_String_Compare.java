import java.util.Stack;

public class Backspace_String_Compare {

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#'){
                s1.push(c);
            }
            else {
                if (!s1.empty()){
                    s1.pop();
                }
            }

        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (c != '#'){
                s2.push(c);
            }
            else {
                if (!s2.empty()){
                    s2.pop();
                }
            }
        }

        //Check if the size of the stack is the same
        if (s1.size()!=s2.size()){
            return false;
        }
        else{
            while (!s1.empty()){
                if (s1.pop()!= s2.pop()){
                    return false;
                }
            }
            return true;
        }

//        while (!s1.empty() && !s2.empty()){
//            char val1 = s1.pop();
//            char val2 = s2.pop();
//
//            if (val1 == '#'){
//                s1.pop();
//                // Case 3: both not valid
//                if (val2 == '#'){
//                    s2.pop();
//                }
//                // Case 4: s1 not valid s2 valid
//                else{
//                   s2.push(val2);
//                }
//            }
//            // When val1 is a valid value
//            else{
//                // Case 1: s1 valid s2 not valid
//                if (val2 == '#'){
//                    s2.pop();
//                    s1.push(val1);
//                }
//                // Case 2: s1 s2 both valid
//                else{
//                    if (val1 != val2){
//                        return false;
//                    }
//                }
//            }
//        }


    }


}
