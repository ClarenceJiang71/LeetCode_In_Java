public class TicTacToe井字游戏_分类 {
    /**
     * 通过字符串表示盘面，判断有没有可能最终形成某种盘面，难度在于盘面可能没下完
     * X 先手
     * Topic: 分类
     *
     * 时间复杂度：O(1), 因为井字棋的size是3x3确定，所以本质就是拿下相应的string
     * index，不需要遍历
     */

    public static void main(String[] args) {
        System.out.println(validBoard(new String[]{"XXX", "OXO", "O O"}));
    }

    public static boolean validBoard(String[] board) {
        // X win, X - O = 1, X win, then X will be the last person playing
        // O win，X - O = 0, O last person, since X is the one play first,
        // No one wins --> this is not finished / tie, both above satisfy
        /**
         * 情况1：轮流落子且X先手，棋子数量X比O多1，或出手数量相等 其他即为不可能出现的盘面
         * 情况2：X win 的情况 还是需要穷举，O win的穷举一样
         */

        int xCount = 0, oCount = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                }
            }
        }

        //判断差值, 只有两种情况合理，其他均为错误盘面，绝对值不对因为X永远比O先手
        if (xCount != oCount && xCount - oCount != 1) {
            return false;
        }

        // X win case
        if (win(board, "XXX") && xCount - oCount != 1){
            return false;
        }
        if (win(board, "OOO") && xCount != oCount){
            return false;
        }

        //逻辑关系：其他情况均有可能为正确盘面：即X，O获胜，以及平局
        return true;
    }

    //Generic method to test if either X or O wins
    static boolean win(String[] board, String flag) {
        for (int i = 0; i < 3; i++) {
            //纵向3连
            if (flag.equals("" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i))) {
                return true;
            }
            //横向3连
            else if (flag.equals(board[i])){
                        return true;
            }
            //斜向3连
            else if (flag.equals(""+ board[0].charAt(0) + board[1].charAt(1)+
                    board[2].charAt(2))){
                return true;
            }
            else if (flag.equals(""+ board[0].charAt(2) + board[1].charAt(1)+
                    board[2].charAt(0))){
                return true;
            }
        }
        return false;
    }
}

