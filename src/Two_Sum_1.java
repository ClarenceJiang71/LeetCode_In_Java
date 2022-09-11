import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Two_Sum_1 {
    public static int[] twoSum1(int[] nums, int target) {
        //Standard method

        int [] result = new int[2];
        int complementary = 0;
        /*
        The logic of num.length/2 is incorrect, as the answer might be at the very
        end of an array.
         */
        for (int i = 0; i< nums.length; i++){
            complementary = target - nums[i];
            for (int j = i+1; j< nums.length; j++){
                if (nums[j] == complementary){
                    result [0] = i;
                    result [1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target){
        //Sorting method that has double time speed, beat 45%

        int [] result = new int[2];
        int complementary = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i: nums){
            a.add(i);
        }
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(nums.length);
        for (int i = 0; i< nums.length; i++){
            table.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i++){
            complementary = target - nums[i];
            for (int j = nums.length-1; j>i; j--){

                if (nums[j] < complementary) {
                    break;
                }
                if (nums[j] == complementary){
                    if (nums[i] == nums[j]){
                        result [0] = a.indexOf(nums[i]);
                        result [1] = table.get(nums[j]);
                        return result;
                    }
                    result [0] = table.get(nums[i]);
                    result [1] = table.get(nums[j]);
                }
            }
        }
        return result;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        // 100% faster method with Hashmap

        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            Integer requiredNum = (Integer)(target - numbers[i]);
            if(indexMap.containsKey(requiredNum)){
                int toReturn[] = {indexMap.get(requiredNum), i};
                return toReturn;
            }

            indexMap.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int [] test_list1 = {3,3};
        int [] result = twoSum3(test_list1, 6);
        System.out.println(Arrays.toString(result));
    }
}
