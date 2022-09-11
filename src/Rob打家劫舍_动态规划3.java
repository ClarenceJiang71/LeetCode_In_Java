public class Rob打家劫舍_动态规划3 {


    /*
    * 新的房子变成了二叉树，相邻节点只有父子关系，思路还是dp
        use recursion involved with DFS
        父子相连的两个node同一天被打劫会触发警报器
    * 只能用null底部去判断最优解
    *
    * */

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode (3, null, null);
        TreeNode node3 = new TreeNode (3, null, node5);
        TreeNode node2 = new TreeNode (2, null, node4);
        TreeNode node1 = new TreeNode (3, node2, node3);
        /**
         * 如何调用: 直接传入
         * 思路梳理：分别递归左右，看左面和右面 选和不选分别的值是多少，再看本节点
         * 如果节点被选，左右不能选，如果不被选，就是看左面和右面，分别偷和不偷，哪个大
         * 然后两边的最优加上成为最终结果，作为本节点的array select，和not select的
         * 两个值。
         *
         * 本质上使用dfs去实现dp
         */
        int [] arr = dfs(node1);
        System.out.println(Math.max(arr[0], arr[1]));

    }

    /**
     *  return an array which collects the result when selecting this node and when
     *  not selecting this node
     */


    public static int[] dfs(TreeNode node){
        // int[] {select_best_result, not_select_best_result}
        if (node == null){
            return new int[]{0,0};
        }
        int [] l = dfs(node.left);
        int [] r = dfs(node.right);

        //Calculate current, if choose left or right, yourself cannot be
        //selected, if choose yourself, left or right cannot be selected
        /**
         * Recall that our data structure, 1 represents not selecting
         * left and right could be both selected, since they are definitely
         * not connected
         */
        int select = node.val+l[1]+r[1];
        /**
         * Check for both left and right, selecting or not, which one is
         * greater. This is vital as each decision affects the lower layer
         */
        int notSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] {select, notSelect};
    }

}
