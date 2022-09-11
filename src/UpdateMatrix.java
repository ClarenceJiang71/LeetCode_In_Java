import java.util.Arrays;
import java.util.LinkedList;

public class UpdateMatrix {
    public static int[][] updateMatrix(int[][] mat) {

        int length = mat.length, width = mat[0].length;

        int [][] ans = new int [length][width];
        int defaultValue = length * 2;
        for (int[] row : ans) {
            Arrays.fill(row, defaultValue);
        }

        //initialize as preparation for dynamic programming
        // ArrayList<int []> zero = new ArrayList<>();
        LinkedList<int []> unAssigned = new LinkedList<>();
        for (int i = 0; i< mat.length; i++){
            for (int j = 0; j< mat[i].length; j++){
                if (mat[i][j] == 0){
                    // zero.add(new int[] {i,j});
                    ans[i][j] = 0;
                }
                else {
                    unAssigned.offer(new int[] {i,j});
                }
            }
        }

//         // Control when the unassigned value is all assigned, Do BFS with the zero values
//         while (!unAssigned.isEmpty()){
//             int a [] = unAssigned.getFirst();
//             int x = a[0], y = a[1];
//             int min = ans[x][y];

//             if (x+1 <= length-1 && ans[x+1][y] != defaultValue){
//                 min = Math.min(ans[x+1][y]+1,min);
//             }
//             if (x-1 >= 0 && ans[x-1][y] != defaultValue){
//                 min = Math.min(ans[x-1][y]+1,min);
//             }
//             if (y+1 <= width-1 && ans[x][y+1] != defaultValue){
//                 min = Math.min(ans[x][y+1]+1,min);
//             }
//             if (y-1 >= 0 && ans[x][y-1] != defaultValue){
//                 min = Math.min(ans[x][y-1]+1, min);
//             }


//             if (min != defaultValue){
//                 ans[x][y] = min;
//                 unAssigned.poll();
//             }
//             // 如果一轮四周还是没东西，放到linkedlist最后
//             else{
//                 unAssigned.offer(unAssigned.poll());
//             }


//         }

        int number = 0;
        int startX = defaultValue, startY=defaultValue;
        while (!unAssigned.isEmpty()){
            // System.out.println(number);
            int a [] = unAssigned.getFirst();
            int x = a[0], y = a[1];

            if (x==startX && y == startY){
                number++;
            }

            if (x+1 <= length-1 && ans[x+1][y] == number){
                ans[x][y] = number+1;
                unAssigned.poll();
            }
            else if (x-1 >= 0 && ans[x-1][y] == number){
                ans[x][y] = number+1;
                unAssigned.poll();
            }
            else if (y+1 <= width-1 && ans[x][y+1] == number){
                ans[x][y] = number+1;
                unAssigned.poll();
            }
            else if (y-1 >= 0 && ans[x][y-1] == number){
                ans[x][y] = number+1;
                unAssigned.poll();
            }


            // if (min != defaultValue){
            //     ans[x][y] = min;
            //     unAssigned.poll();
            // }
            // 如果一轮四周还是没东西，放到linkedlist最后
            else{
                startX = x;
                startY = y;
                unAssigned.offer(unAssigned.poll());

            }


        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0}
        ,{0,1,1,1,0,1,1,1,1,1}, {0,0,1,1,1,1,1,1,1,0}, {1,1,1,1,1,1,0,1,1,1}, {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1}, {0,1,0,1,1,0,1,1,1,1}, {1,1,1,0,1,0,1,1,1,1}};
        int [] [] mat =updateMatrix(a);
        for (int i = 0; i < mat.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] + " ");
            }

        }



    }
}
