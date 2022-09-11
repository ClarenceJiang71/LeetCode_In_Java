import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String s) {

        //Some edges cases are not well considered like only "]" or "["
        Stack<Character> stack = new Stack<>();
//        boolean result = true;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '['|| c=='{'){
                stack.push(c);
            }
            else if (c == ')' && !stack.empty()){
                char top = stack.peek();
                if (top == '('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if (c == ']' && !stack.empty()){
                char top = stack.peek();
                if (top == '['){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if (c == '}' && !stack.empty()){
                char top = stack.peek();
                if (top == '{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }

        if (!stack.empty()){
            return false;
        }

        return true;

    }



    public static void main(String[] args) {

    }
}
