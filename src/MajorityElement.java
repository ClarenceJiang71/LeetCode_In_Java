import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums){
        int threshold = nums.length/2;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i], value+1);
            }
            else{
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > threshold){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
