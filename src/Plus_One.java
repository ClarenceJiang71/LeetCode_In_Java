public class Plus_One {
    public static int[] plusOne(int[] digits) {
        // Run faster than 100% , perfect code

        if (digits[digits.length-1] != 9){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }

        //Need calculation
        for (int j = digits.length-1; j>=0; j--){
            if ((digits[j]+1) > 9){
                digits[j] = 0;
            }
            else{
                digits[j] = digits[j]+1;
                return digits;
            }
        }

        //The edge case needs to add a digit in the front
        int [] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

    }
}
