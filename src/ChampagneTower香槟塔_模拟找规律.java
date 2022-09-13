public class ChampagneTower香槟塔_模拟找规律 {
    /**
     * Description: wine divides equally to its left and right side
     * bottles, input n cups of champanges, calculate the [row, col]
     * cup, how much percentage of wine?
     *
     * 规律1：杯子左下的坐标和本身本子的坐标是一样的，右下是本身列号+1
     */

    public static void main(String[] args) {
        System.out.println(champagneTower(5,2,1));
    }

    public static double champagneTower(int poured, int row, int glass){
        double[][] ca = new double[100][100];
        ca[0][0] = poured;
        for(int r = 0; r<=row; r++){
            //规律2：第二行最多两列，第三行最多三列，列数跟行号本身就是相等的
            //不小于等于，第一列比0和0，直接都不过了
            for (int l = 0; l<=r; l++){
                double d = (ca[r][l]-1.0)/2;
                if (d > 0){
                    ca[r+1][l] += d;
                    ca[r+1][l+1] += d;
                }
            }
        }
        // 规律3：走完到目标行已经足以判断 目标杯子，如果大于1，取1，小于1，取具体值
        return (ca[row][glass]>=1) ? 1.0 : ca[row][glass];

    }
}
