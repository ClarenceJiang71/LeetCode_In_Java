import java.util.LinkedList;
import java.util.Queue;

public class Dota2Dota2参议院_贪心 {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }

    public static String predictPartyVictory(String senate){
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R'){
                r.offer(i);
            }
            else{
                d.offer(i);
            }
        }
        //控制条件，当两个队列有任意一个被掏空了 一直进行因为不知道第几轮结束
        while(!r.isEmpty() && !d.isEmpty()){
            int rPoll = r.poll(), dPoll = d.poll();
            if (rPoll < dPoll){
                //小的放到队列尾部,避免同一个index 要加length 控制到尾部
                r.offer(rPoll+length);
            }
            else{
                d.offer(dPoll+length);
            }
        }

        //如果d空了，证明全被r挤走了
        return d.isEmpty()? "R": "D";
    }
}
