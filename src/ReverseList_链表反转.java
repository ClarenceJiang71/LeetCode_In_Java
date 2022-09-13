public class ReverseList_链表反转 {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //迭代
    public static ListNode iterate(ListNode head){
        ListNode prev = null, next;
        ListNode curr = head;

        while(curr!=null){
            //把2存到next
            next = curr.next;
            //把1--->2断开，1--->null
            curr.next = prev;
            //把1存到curr，方便之后2接回来
            prev = curr;
            //curr iterate next round
            curr = next;
        }

        return prev;
    }

    // recursion
    public  static ListNode recursion(ListNode head){
        //当head本身为空，不需要反转 处理特殊情况
        //当已经走到最后一个node, 最后一个node开始反转了
        if (head == null || head.next == null){
            return head; //这里最开始输出的就是末尾的node，正好是return的node
        }
        ListNode ans = recursion(head.next);

        head.next.next = head;
        head.next = null;

        return ans;
    }
}
