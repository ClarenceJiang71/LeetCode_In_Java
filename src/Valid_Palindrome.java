public class Valid_Palindrome {

    public static boolean isPalindrome(String s) {

        int pointer1 = 0;
        int pointer2 = s.length()-1;

        while (pointer1<pointer2){
            char left = s.charAt(pointer1);
            char right = s.charAt(pointer2);
            if (Character.isAlphabetic(left) || Character.isDigit(left)){

                if (Character.isAlphabetic(left) && Character.isUpperCase(left)){
                    left = Character.toLowerCase(left);
                }

                if (Character.isAlphabetic(right)|| Character.isDigit(right)){

                    if (Character.isAlphabetic(right) &&Character.isUpperCase(right)){
                        right = Character.toLowerCase(right);
                    }

                    if (left != right){
                        return false;
                    }
                    pointer2--;
                    pointer1++;

                }
                else{
                    pointer2--;
                }

            }
            else{
                pointer1++;
            }
        }


        return true;

    }
}
