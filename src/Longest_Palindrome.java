public class Longest_Palindrome {
    public int longestPalindrome(String s) {

        int [] alpha = new int[52];
        int left = 0;
        int count = 0;
        boolean oddCheck = false;

        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if (Character.isUpperCase(c)){
                int value = c;
                int index = value % 65;
                alpha [index] = alpha[index] + 1;
            }
            else{
                int value = c;
                int index = (value % 97) + 26;
                alpha [index] = alpha [index] + 1;
            }

        }

        for (int value: alpha){
            if (value != 0 && value % 2 == 0){
                count += value;
            }
            // if value is an odd number > 1
            else if (value != 1 && value %2 == 1){
                count += (value - 1);
                oddCheck = true;
            }
            else if (value == 1){
                oddCheck = true;
            }
        }

        if (oddCheck) {
            count += 1;
        }

        return count;

    }
}
