import java.util.Hashtable;

public class DuplicateElement {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("duplicate element present :" + findDuplicate(nums));
    }

    private static boolean findDuplicate(int[] nums) {
        int n = nums.length;
        Hashtable<Object, Object> ht = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            if (ht.containsKey(nums[i])) {
                return true;
            }
            ht.put(nums[i], 1);
        }
        return false;
    }
}
