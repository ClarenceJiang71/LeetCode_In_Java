public class Rob打家劫舍_动态规划2 {

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,1};
        int [] nums1 = new int[] {2,7,9,3,1};
        int length = nums1.length;
        System.out.println(Math.max(maxMoneyDP2(nums1, 0, length-2), maxMoneyDP2(nums1, 1, length-1)));
    }

    static int maxMoney(int [] nums, int index){
        if (nums == null || index < 0){
            return 0;
        }
        // 如果数组本来就只有一个 返回第一位，这里只用index == 0 就足以控制
        // 因为不断减1减2会cover到所有可能性
        if (index == 0){
            return nums[0];
        }
        // 别忘了 往前走两位还得加上最后出发点，前一步不能加最后出发点 因为相邻
        return Math.max(maxMoney(nums, index-1), maxMoney(nums, index-2)+ nums[index]);
    }

    //首尾相连要处理了 前后只能取其一， 0和length-1取其一，
    //很简单的思路：从0到length-2算出一个答案，从1到length-1算出一个答案
    //再比大小
    static int maxMoneyDP2(int [] nums, int start, int end){
       int first = nums[start], second = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp = second; //当前最大值
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        return second;
    }
}
