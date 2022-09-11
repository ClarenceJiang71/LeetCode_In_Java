import java.util.HashSet;

public class Contain_Duplicate {

    //Hashset only contains unique key, so if returns false, it means there is a duplicate
    public boolean containsDuplicate(int [] nums){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
