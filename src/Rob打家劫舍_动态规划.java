public class Rob打家劫舍_动态规划 {

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,1};
        int [] nums1 = new int[] {2,7,9,3,1};
        System.out.println(maxMoney(nums1, nums1.length-1));
        System.out.println(maxMoneyDP(nums1));
    }

    //1.普通递归找到每一个 index 所能得到的最优解
    //base case 只有一个的时候 return 一个 有两种解法的时候比较大小

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

    //2.递归里很明显 i-1的下一轮递归涉及到了i-2 有重复计算
    // 不用递归 用迭代了
    static int maxMoneyDP(int [] nums){
        int length = nums.length;

        if (nums == null || nums.length == 0){
            return 0;
        }
        
        if (length == 1){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        dp [0] = nums[0];
        dp [1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(maxMoney(nums, i-1), maxMoney(nums, i-2)+ nums[i]);
        }

        return dp[length-1];
    }
}
