import java.util.*;

public class Horse_Racing优势洗牌_贪心 {

    public static void main(String[] args) {
        int[] A = new int[] {10,24, 8, 32};
        int[] B = new int[] {13,25,25,11};

        System.out.println(Arrays.toString(advantageCount(A,B)));
    }

    public static int[] advantageCount(int [] A, int [] B){
        int [] sortB = B.clone();
        Arrays.sort(sortB);
        Arrays.sort(A);

        Map<Integer, Deque<Integer>> bMap = new HashMap<>();
        for(int b: B){
           bMap.put(b, new LinkedList<>());
        }

        //A数组对应的垃圾桶
        Deque<Integer> aq = new LinkedList<>();

        int j = 0;
        for(int a : A){
            if (a > sortB[j]){
                //如果a放进来了 b直接move到下一位
                bMap.get(sortB[j++]).add(a); //把b的每一个值后面attach上a的小数
            }
            else{
                //a放入垃圾桶待定
                aq.add(a);
            }
        }

        //用sortB 来帮助提高算法速度，每一个key在original B array里的顺序就不重要了
        int [] ans = new int[A.length];
        for (int i = 0; i<B.length; i++){
            if (!bMap.get(B[i]).isEmpty()){
                ans[i] = bMap.get(B[i]).removeLast();
            }
            else{
                ans[i] = aq.removeLast();
            }
        }
        return ans;
    }
}
