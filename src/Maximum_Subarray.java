public class Maximum_Subarray {

    public static int maxSubArray(int[] nums) {
        int [] a = new int[nums.length];
        a[0] = nums[0];

        for (int i = 1; i< nums.length; i++){

            if (a[i-1] < 0){
                a[i] = nums[i];
            }
            else{
                a[i] = nums[i] + a[i-1];
            }
        }

        int max = -10000;
        for (int i = 0 ; i<a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }

        return max;
    }
}
